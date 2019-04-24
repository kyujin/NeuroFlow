package com.example.neuroflow.data

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_table")
data class User @Ignore constructor(@SerializedName("name")
                                    @Expose
                                    val name: String,

                                    @SerializedName("score")
                                    @Expose
                                    val score: Int,

                                    @SerializedName("date_created")
                                    @Expose
                                    val time: Long) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var isFemale: Boolean = false

    constructor(id: Int, name: String, score: Int, time: Long, isFemale: Boolean) : this(name, score, time) {
        this.id = id
        this.isFemale = isFemale
    }

    @Ignore
    constructor(name: String, score: Int, time: Long, isFemale: Boolean) : this(name, score, time) {
        this.isFemale = isFemale
    }
}