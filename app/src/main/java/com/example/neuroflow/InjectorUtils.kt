package com.example.neuroflow

import android.content.Context
import com.example.neuroflow.data.UserDatabase
import com.example.neuroflow.repository.UserRepository
import com.example.neuroflow.viewmodel.UserListViewModelFactory
import com.example.neuroflow.viewmodel.UserViewModelFactory

object InjectorUtils {

    private fun getUserRepository(context: Context): UserRepository {
        return UserRepository.getInstance(UserDatabase.getInstance(context).userDao())
    }

    fun provideUserViewModelFactory(context: Context, userId: Int): UserViewModelFactory {
        val repository = getUserRepository(context)
        return UserViewModelFactory(repository, userId)
    }

    fun provideUserListViewModelFactory(context: Context): UserListViewModelFactory {
        val repository = getUserRepository(context)
        return UserListViewModelFactory(repository)
    }
}