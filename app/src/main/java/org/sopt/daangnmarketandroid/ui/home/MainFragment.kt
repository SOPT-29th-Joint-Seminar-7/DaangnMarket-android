package org.sopt.daangnmarketandroid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import org.sopt.daangnmarketandroid.R
import org.sopt.daangnmarketandroid.databinding.FragmentMainBinding
import org.sopt.daangnmarketandroid.ui.home.adapter.ProductListAdapter
import org.sopt.daangnmarketandroid.ui.home.data.ProductListData

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val adapter = ProductListAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        addListEvent()
    }

    private fun initAdapter() {
        val dividerItemDecoration =
            DividerItemDecoration(
                binding.recyclerProductList.context,
                LinearLayoutManager(requireContext()).orientation
            )
        binding.recyclerProductList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(dividerItemDecoration)
        }
        binding.recyclerProductList.adapter = adapter
    }

    private fun addListEvent() {
        adapter.setItems(
            listOf(
                ProductListData(
                    R.drawable.image_example,
                    "중고",
                    "택배",
                    "바비브라운 립스틱",
                    "성동구 행당제2동",
                    "10,000원"
                ),
                ProductListData(
                    R.drawable.image_example2,
                    "중고",
                    "택배",
                    "커버낫 후드티 M",
                    "동대문구 휘경동",
                    "45,000원"
                ),
                ProductListData(
                    R.drawable.image_example3,
                    "중고",
                    "택배",
                    "홀로그램 조개 트레이",
                    "동대문구 답십리동",
                    "4,000원"
                ),
                ProductListData(
                    R.drawable.image_example4,
                    "중고",
                    "택배",
                    "퍼플키스 폰조나 포토카드",
                    "안암동",
                    "3,000원"
                ),
                ProductListData(
                    R.drawable.image_example,
                    "중고",
                    "택배",
                    "바비브라운 립스틱",
                    "성동구 행당제2동",
                    "10,000원"
                )
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
