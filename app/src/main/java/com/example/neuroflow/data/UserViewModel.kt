package com.example.neuroflow.data

import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*


class UserViewModel : ViewModel() {

    val users: List<User> = listOf(
        User("Ryan", 85, 1546341851000),
        User("Melissa", 90, 1536442851000),
        User("Sam", 98, 1546442992000),
        User("Joe", 75, 1535342994000))

    val user: User
        get() = getRandomElement(users)

    fun getFormattedTime(user: User): String {
        return SimpleDateFormat("MM/dd/yyyy\nHH:mm:ss").format(Date(user.time))
    }

    fun getRandomElement(list: List<User>): User {
        val rand = Random()
        return list[rand.nextInt(list.size)]
    }
}