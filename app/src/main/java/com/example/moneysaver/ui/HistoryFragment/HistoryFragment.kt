package com.example.moneysaver.ui.HistoryFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moneysaver.R
import com.example.moneysaver.data.db.MoneySaverDatabase
import com.example.moneysaver.data.db.entities.ExpenseModelClass
import com.example.moneysaver.data.room_repostories.ExpenseRepository
import com.example.moneysaver.databinding.FragmentHistoryBinding
import com.example.moneysaver.databinding.FragmentMainBinding
import com.example.moneysaver.repostories.ClientRepository
import com.example.moneysaver.ui.mainfragment.MainFragmentViewModel
import com.example.moneysaver.ui.mainfragment.MainFragmentViewModelFactory
import com.example.moneysaver.utils.ExpenseAdapter

class HistoryFragment : Fragment() {
    private  lateinit var binding: FragmentHistoryBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list= mutableListOf<ExpenseModelClass>()
        val database = MoneySaverDatabase(requireContext())
        val repository = ExpenseRepository(database)
        val factory = HistoryFragmentViewFactory(repository,requireContext())
        val provider = ViewModelProvider(this, factory)
        val viewModel = provider.get(HistoryFragmentViewModel::class.java)
        val adapter = ExpenseAdapter(list, binding)

        binding.rvExpensesItems.layoutManager = LinearLayoutManager(requireContext())
        binding.rvExpensesItems.adapter = adapter

        viewModel.getCurrentUserData(viewModel.getId()).observe(viewLifecycleOwner,{
            adapter.dataSEt=it
            adapter.notifyDataSetChanged()


        })




    }
}