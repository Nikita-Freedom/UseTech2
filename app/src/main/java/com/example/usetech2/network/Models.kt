package com.example.usetech2.network

import com.example.usetech2.network.entity.*
import com.google.gson.annotations.SerializedName

sealed class Models {

    data class NameResponse(
        @SerializedName("response")
        val response: String,

        @SerializedName("results-for")
        val resultsFor: String,

        @SerializedName("results")
        val results: List<SuperHero>,
    )

    data class IdResponse(
        @SerializedName("response")
        val response: String,

        @SerializedName( "id")
        val id: String,

        @SerializedName("name")
        val name: String,

        @SerializedName("powerstats")
        val powerStats: Powerstats,

        @SerializedName("biography")
        val biography: Biography,


        @SerializedName("appearance")
        val appearance: Appearance,

        @SerializedName("work")
        val work: Work,

        @SerializedName("connections")
        val connections: Connections,

        @SerializedName("image")
        val image: Image
    )


    data class SuperHero(
        @SerializedName("id")
        var id: String,

        @SerializedName("name")
        var name: String,

        @SerializedName("powerstats")
        val powerStats: Powerstats,

        @SerializedName("biography")
        val biography: Biography,

        @SerializedName("appearance")
        val appearance: Appearance,

        @SerializedName("work")
        val work: Work,

        @SerializedName("connections")
        val connections: Connections,

        @SerializedName("image")
        val image: Image
    )
}
