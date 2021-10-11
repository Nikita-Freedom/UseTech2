package com.example.usetech2.ui.superheroeslist

import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.usetech2.ui.base.BaseViewModel
import com.example.usetech2.domain.dataSource.SuperHeroesDataSourceFactory
import com.example.usetech2.network.Models
import javax.inject.Inject

private const val PAGE_SIZE = 20
private const val INITIAL_LOAD_SIZE_HINT = 40

class SuperheroesViewModel @Inject constructor(
    private val dataSourceFactory: SuperHeroesDataSourceFactory
) : BaseViewModel<PagedList<Models.SuperHero>>() {
    var cachedFilter: String = ""
    fun setFilter(filter: String) {
        dataSourceFactory.setFilter(if (cachedFilter.isEmpty()) filter else cachedFilter)
    }

    init {
        createLiveData()
    }

    fun createLiveData() {
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(INITIAL_LOAD_SIZE_HINT)
            .setPageSize(PAGE_SIZE)
            .build()
        this.stateLiveData = LivePagedListBuilder(dataSourceFactory, pagedListConfig).build();
    }
}