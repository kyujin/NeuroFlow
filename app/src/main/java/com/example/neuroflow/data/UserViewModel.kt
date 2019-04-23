package com.example.neuroflow.data

import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

data class UserViewModel(val name: String = "Mike",
                         val score: Int = 100,
                         val time: Long = System.currentTimeMillis()) : ViewModel() {

    fun getFormattedTime(): String {
        return SimpleDateFormat("MM/dd/yyyy\nHH:mm:ss").format(Date(time))
    }
}