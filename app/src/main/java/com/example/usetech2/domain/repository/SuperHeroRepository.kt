package com.example.usetech2.domain.repository

import com.example.usetech2.domain.entity.SuperHeroModel
import com.example.usetech2.network.Models

import io.reactivex.Single

interface SuperHeroRepository {
    fun getById(id: SuperHeroModel): Single<Models.IdResponse>
    fun getByName(name: String):  Single<Models.NameResponse>
}