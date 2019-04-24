package com.example.neuroflow.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neuroflow.repository.UserRepository
import kotlinx.coroutines.launch

class UserListViewModel(val repository: UserRepository) : ViewModel() {

    val users = repository.getUsers()
    val femaleUsers = repository.getFemaleUsers()
    val maleUsers = repository.getMaleUsers()
}