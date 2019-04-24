package com.example.neuroflow.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.neuroflow.repository.UserRepository

class UserViewModelFactory(private val repository: UserRepository,
                           private val userId: Int) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = UserViewModel(repository, userId) as T
}