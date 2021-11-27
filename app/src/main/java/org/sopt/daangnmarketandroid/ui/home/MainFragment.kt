package org.sopt.daangnmarketandroid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import org.sopt.daangnmarketandroid.api.ServiceCreator
import org.sopt.daangnmarketandroid.databinding.FragmentMainBinding
import org.sopt.daangnmarketandroid.ui.home.adapter.ProductListAdapter
import org.sopt.daangnmarketandroid.util.enqueueUtil

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
        val call = ServiceCreator.apiService.getProductInfo()

        call.enqueueUtil(
            onSuccess = {
                adapter.setItems(it.data)
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
