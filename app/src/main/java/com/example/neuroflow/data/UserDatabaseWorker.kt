package com.example.neuroflow.data

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.neuroflow.network.BaseRepository
import com.example.neuroflow.network.NetworkInjector
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope

class UserDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    private val TAG: String = UserDatabaseWorker::class.java.simpleName


    override val coroutineContext = Dispatchers.IO

    override suspend fun doWork(): Result = coroutineScope {
        val database = UserDatabase.getInstance(applicationContext)
        populateDatabaseFromRequests(database.userDao())

        Result.success()
    }

    /**
     * Populate the database in a new coroutine.
     * If you want to start with more words, just add them.
     */
    fun populateDatabase(userDAO: UserDAO) {

        var user = User("Ryan", 85, 1546341851000, false)
        userDAO.insert(user)
        user = User("Melissa", 90, 1536442851000, true)
        userDAO.insert(user)
        user = User("Sam", 98, 1546442992000, true)
        userDAO.insert(user)
        user = User("Joe", 75, 1535342994000, false)
        userDAO.insert(user)
        user = User("Jess", 93, 1540341751000, true)
        userDAO.insert(user)
        user = User("Carly", 89, 1540341651000, true)
        userDAO.insert(user)
        user = User("Mark", 91, 0, false)
        userDAO.insert(user)
    }

    suspend fun populateDatabaseFromRequests(userDAO: UserDAO) {
        val response = BaseRepository.requestData(call = { NetworkInjector.service.listUsers().await() })
        when (response) {
            is com.example.neuroflow.network.Result.Success -> {
                var females: List<User> = emptyList()
                var males: List<User> = emptyList()
                response.data.forEach {userResponse ->
                    if (!userResponse.females.isNullOrEmpty()) {
                        females = userResponse.females
                    }
                    if (!userResponse.males.isNullOrEmpty()) {
                        males = userResponse.males
                    }
                }

                females.forEach { user -> user.isFemale = true }
                males.forEach { user -> user.isFemale = false }
                val users = males + females
                userDAO.insertAll(users)

            }
            is com.example.neuroflow.network.Result.Error -> {
                Log.d(TAG, "Network Error")
            }
        }
    }
}