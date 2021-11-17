package org.sopt.daangnmarketandroid.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.daangnmarketandroid.databinding.ItemProductListBinding
import org.sopt.daangnmarketandroid.ui.home.data.ProductListData

class ProductListAdapter: RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>() {

    private val productList = mutableListOf<ProductListData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val binding = ItemProductListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        holder.onBind(productList[position], position)
    }

    override fun getItemCount(): Int = productList.size

    fun setItems(newItems: List<ProductListData>) {
        productList.clear()
        productList.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class ProductListViewHolder(
        private var binding: ItemProductListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(productList: ProductListData , position: Int) {
            binding.apply {
                imageProduct.setImageResource(productList.Image)
                tvStatus.text = productList.status
                tvDelivery.text = productList.delivery
                tvProductName.text = productList.productName
                tvLocation.text = productList.location
                tvPrice.text = productList.price
            }
        }
    }
}