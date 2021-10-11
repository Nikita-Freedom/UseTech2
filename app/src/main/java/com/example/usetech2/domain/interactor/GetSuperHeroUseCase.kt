package com.example.usetech2.domain.interactor

import com.example.usetech2.domain.executer.UseCaseExecutor
import com.example.usetech2.domain.interactor.base.SingleUseCase
import com.example.usetech2.domain.repository.SuperHeroRepository
import com.example.usetech2.domain.executer.PostExecutionThread
import com.example.usetech2.domain.entity.SuperHeroModel
import com.example.usetech2.network.Models
import io.reactivex.Single
import javax.inject.Inject

class GetSuperHeroUseCase @Inject
constructor(
    useCaseExecutor: UseCaseExecutor,
    postExecutionThread: PostExecutionThread,
    repository: SuperHeroRepository
) : SingleUseCase<Models.NameResponse, SuperHeroModel>(useCaseExecutor, postExecutionThread, repository) {
    override fun interact(params: SuperHeroModel): Single<Models.NameResponse> {
        return repository.getByName("search/${params.name}")
    }
}