package com.example.neuroflow.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.neuroflow.data.User
import com.example.neuroflow.repository.UserRepository
import java.text.SimpleDateFormat
import java.util.*


class UserViewModel(val repository: UserRepository,
                    val userId: Int) : ViewModel() {

    val user: LiveData<User> = repository.getUser(userId)

    @SuppressLint("SimpleDateFormat")
    fun getFormattedTime(user: User?): String {
        return if (user != null) {
            SimpleDateFormat("MM/dd/yyyy\nHH:mm:ss").format(Date(user.time))
        } else {
            ""
        }
    }

    fun getRandomElement(list: List<User>): User {
        val rand = Random()
        return list[rand.nextInt(list.size)]
    }
}