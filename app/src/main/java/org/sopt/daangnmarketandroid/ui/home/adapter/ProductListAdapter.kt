package org.sopt.daangnmarketandroid.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.daangnmarketandroid.databinding.ItemProductListBinding
import org.sopt.daangnmarketandroid.ui.home.data.ResponseProductData

class ProductListAdapter : RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>() {

    private val productList = mutableListOf<ResponseProductData.Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val binding =
            ItemProductListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        holder.onBind(productList[position])
    }

    override fun getItemCount(): Int = productList.size

    fun setItems(newItems: List<ResponseProductData.Data>) {
        productList.clear()
        productList.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class ProductListViewHolder(
        private var binding: ItemProductListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(productList: ResponseProductData.Data) {
            binding.data = productList
        }
    }
}
