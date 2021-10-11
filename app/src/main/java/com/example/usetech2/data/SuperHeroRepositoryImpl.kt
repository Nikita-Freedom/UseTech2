package com.example.usetech2.data

import android.annotation.SuppressLint
import com.example.usetech2.network.api.SuperHeroApi
import com.example.usetech2.domain.repository.SuperHeroRepository
import com.example.usetech2.domain.entity.SuperHeroModel
import com.example.usetech2.network.Models
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Inject


internal class SuperHeroRepositoryImpl @Inject constructor(
    private val superHeroApi: SuperHeroApi
) : SuperHeroRepository {
    @SuppressLint("CheckResult")

    override fun getById(param: SuperHeroModel): Single<Models.IdResponse> {
        return  Single.create { emitter ->
            superHeroApi.getById(param.id).subscribe ({ response ->
                Timber.d("response : %s", response)
                emitter.onSuccess(response)
            },
                {
                    emitter.onError(it)
                })
        }
    }

    @SuppressLint("CheckResult")
    override fun getByName(param: String): Single<Models.NameResponse> {
        return  Single.create { emitter ->
            superHeroApi.getByName(param).subscribe ({ response ->
                Timber.d("response : %s", response)
                emitter.onSuccess(response)
            },
            {
                emitter.onError(it)
            })
        }

    }

}