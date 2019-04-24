package com.example.neuroflow.network

import com.example.neuroflow.data.User
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserResponse(@SerializedName("females")
                        @Expose
                        val females: List<User>,

                        @SerializedName("males")
                        @Expose
                        val males: List<User>)