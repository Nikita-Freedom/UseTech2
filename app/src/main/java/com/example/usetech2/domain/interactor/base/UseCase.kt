package com.example.usetech2.domain.interactor.base

import com.example.usetech2.domain.executer.UseCaseExecutor
import com.example.usetech2.domain.executer.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.Single


abstract class UseCase<Responses, Params>(
    private val useCaseExecutor: UseCaseExecutor,
    private val postExecutionThread: PostExecutionThread
) {
    private fun getUseCaseExecutor(): Scheduler {
        return useCaseExecutor.scheduler
    }

    private fun getPostExecutionThread(): Scheduler {
        return postExecutionThread.scheduler
    }

    fun <T> Single<T>.applySchedulers(): Single<T> {
        return subscribeOn(getUseCaseExecutor()).observeOn(getPostExecutionThread())
    }
}