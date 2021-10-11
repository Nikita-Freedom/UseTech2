package com.example.usetech2.domain.interactor.base

import com.example.usetech2.domain.executer.UseCaseExecutor
import com.example.usetech2.domain.repository.SuperHeroRepository
import com.example.usetech2.domain.executer.PostExecutionThread
import io.reactivex.Single


abstract class SingleUseCase<Responses, Params>(
    useCaseExecutor: UseCaseExecutor,
    postExecutionThread: PostExecutionThread,
    protected var repository: SuperHeroRepository
) :
    UseCase<Single<Responses>, Params>(useCaseExecutor, postExecutionThread) {

    open fun execute(params: Params): Single<Responses> {
        return interact(params).applySchedulers()
    }

    protected abstract fun interact(params: Params): Single<Responses>

}