package com.example.neuroflow.viewmodel

import androidx.lifecycle.ViewModel
import com.example.neuroflow.repository.UserRepository

class UserListViewModel(val repository: UserRepository) : ViewModel() {

    val users = repository.getUsers()
    val femaleUsers = repository.getFemaleUsers()
    val maleUsers = repository.getMaleUsers()
}