package com.example.usetech2.network.entity

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Powerstats(
    @SerializedName("intelligence")
    val intelligence: String,

    @SerializedName("strength")
    val strength: String,

    @SerializedName("speed")
    val speed: String,

    @SerializedName("durability")
    val durability: String,

    @SerializedName("power")
    val power: String,

    @SerializedName("combat")
    val combat: String
)
