package com.example.neuroflow.network

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface UserService {

    @GET("ryanneuroflow/370d19311602c091928300edd7a40f66/raw/1865ae6004142553d8a6c6ba79ccb511028a2cba/names.json")
    fun listUsers(): Deferred<Response<List<UserResponse>>>
}