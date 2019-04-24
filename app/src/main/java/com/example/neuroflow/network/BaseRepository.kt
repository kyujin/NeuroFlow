package com.example.neuroflow.network

import retrofit2.Response

object BaseRepository {

    suspend fun <T: Any> requestData(call: suspend ()-> Response<T>) : Result<T>{

        val response = call.invoke()
        if(response.isSuccessful) return Result.Success(response.body()!!)

        return Result.Error(response.code())
    }
}

sealed class Result<out T: Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val code: Int) : Result<Nothing>()
}