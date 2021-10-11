package com.example.usetech2.domain.dataSource

import androidx.paging.PositionalDataSource
import javax.inject.Inject
import com.example.usetech2.domain.interactor.GetSuperHeroUseCase
import com.example.usetech2.domain.entity.SuperHeroModel
import com.example.usetech2.network.Models
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber


class SuperHeroPositionalDataSource @Inject constructor(
    private val getSuperHeroUseCase: GetSuperHeroUseCase
) : PositionalDataSource<Models.SuperHero>(), Disposable {

    private var disposing = false
    override fun isDisposed(): Boolean {
        return disposing
    }

    override fun dispose() {
        disposing = true
        compositeDisposable.clear()
    }

    private var filter: String = ""
    fun setFilter(filter: String) {
        this.filter = filter
    }

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private fun computeCount(): String {
        return getSuperHeroUseCase.execute(SuperHeroModel()).blockingGet().response
    }



    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Models.SuperHero>) {
        val pageNum = params.startPosition / params.loadSize + 1
        val disposable = getSuperHeroUseCase.execute(SuperHeroModel()).subscribe({ response ->
            callback.onResult(response.results);
        }, { t: Throwable? ->
            Timber.e(t)
        })
        compositeDisposable.add(disposable)
    }

    override fun loadInitial(
        params: LoadInitialParams,
        callback: LoadInitialCallback<Models.SuperHero>
    ) {
        val totalCount = 0
        val position = computeInitialLoadPosition(params, totalCount)
        val loadSize = computeInitialLoadSize(params, position, totalCount)
        val disposable = getSuperHeroUseCase.execute(SuperHeroModel(filter)).subscribe({ response ->
            callback.onResult(response.results, position, response.response.toInt())
        }, { t: Throwable? ->
            Timber.e(t)
        })
        compositeDisposable.add(disposable)
    }

}