package com.example.moneysaver.ui.ProfileFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moneysaver.repostories.MoneySaverRepository
import com.example.moneysaver.ui.signIn.SignInViewModel

class ProfileViewModelFactory (private val repository: MoneySaverRepository): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileViewModel( repository) as T
    }
}