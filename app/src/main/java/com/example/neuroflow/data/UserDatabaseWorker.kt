package com.example.neuroflow.data

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope

class UserDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    override val coroutineContext = Dispatchers.IO

    override suspend fun doWork(): Result = coroutineScope {
        val database = UserDatabase.getInstance(applicationContext)
        populateDatabase(database.userDao())

        Result.success()
    }

    /**
     * Populate the database in a new coroutine.
     * If you want to start with more words, just add them.
     */
    fun populateDatabase(userDAO: UserDAO) {

        var user = User(1,"Ryan", 85, 1546341851000, false)
        userDAO.insert(user)
        user = User(2, "Melissa", 90, 1536442851000, true)
        userDAO.insert(user)
        user = User(3, "Sam", 98, 1546442992000, true)
        userDAO.insert(user)
        user = User(4, "Joe", 75, 1535342994000, false)
        userDAO.insert(user)
        user = User(5, "Jess", 93, 1540341751000, true)
        userDAO.insert(user)
        user = User(6, "Carly", 89, 1540341651000, true)
        userDAO.insert(user)
        user = User(7, "Mark", 91, 0, false)
        userDAO.insert(user)
    }
}