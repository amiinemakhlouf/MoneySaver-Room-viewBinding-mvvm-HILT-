package com.example.moneysaver.ui.mainfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moneysaver.data.room_repostories.ExpenseRepository
import com.example.moneysaver.repostories.ClientRepository
import com.example.moneysaver.ui.ProfileFragment.ProfileViewModel

class MainFragmentViewModelFactory (private val repository: ExpenseRepository): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainFragmentViewModel( repository) as T
    }
}