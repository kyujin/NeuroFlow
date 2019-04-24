package com.example.neuroflow.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDAO {

    @Query("SELECT * FROM user_table")
    fun getUsers(): LiveData<List<User>>

    @Query("SELECT * FROM user_table WHERE id = :userId")
    fun getUser(userId: Int): LiveData<User>

    @Insert
    fun insert(user: User)

    @Query("SELECT * FROM user_table WHERE isFemale = 0 ORDER BY time ASC")
    fun getMaleUsers(): LiveData<List<User>>

    @Query("SELECT * FROM user_table WHERE isFemale = 1 ORDER BY time ASC")
    fun getFemaleUsers(): LiveData<List<User>>
}