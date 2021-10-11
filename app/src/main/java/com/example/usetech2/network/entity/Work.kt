package com.example.usetech2.network.entity

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Work(
    @SerializedName("occupation")
    var occupation: String,

    @SerializedName("base")
    val base: String
)
