package com.example.usetech2.network.api

import com.example.usetech2.network.Models
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface SuperHeroApi {

    companion object {
        const val BASE_URL = "https://superheroapi.com/api/997303567756828/"
    }

    @GET
    fun getById(@Url id: String): Single<Models.IdResponse>

    @GET
    fun getByName(@Url name: String): Single<Models.NameResponse>

}