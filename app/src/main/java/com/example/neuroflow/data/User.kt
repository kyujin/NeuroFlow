package com.example.neuroflow.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(@PrimaryKey val id: Int,
                val name: String,
                val score: Int,
                val time: Long,
                val isFemale: Boolean)