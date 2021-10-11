package com.example.usetech2.network.entity

import com.google.gson.annotations.SerializedName

data class Connections(
    @SerializedName("group-affiliation")
    val groupAffiliation: String,

    @SerializedName("relatives")
    var relatives: String
)
