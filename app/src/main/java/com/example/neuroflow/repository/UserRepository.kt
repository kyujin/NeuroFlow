package com.example.neuroflow.repository

import com.example.neuroflow.data.UserDAO

class UserRepository private constructor(private val userDAO: UserDAO) {

    fun getUsers() = userDAO.getUsers()

    fun getMaleUsers() = userDAO.getMaleUsers()

    fun getFemaleUsers() = userDAO.getFemaleUsers()

    fun getUser(id: Int) = userDAO.getUser(id)

    companion object {

        @Volatile
        private var INSTANCE: UserRepository? = null

        fun getInstance(userDAO: UserDAO): UserRepository {
            return INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: UserRepository(userDAO).also { INSTANCE = it }
            }
        }
    }
}