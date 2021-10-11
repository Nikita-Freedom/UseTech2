package com.example.usetech2.domain.dataSource

import androidx.paging.DataSource
import com.example.usetech2.network.Models
import javax.inject.Inject

class SuperHeroesDataSourceFactory @Inject constructor(
    private val dataSource: SuperHeroPositionalDataSource
) : DataSource.Factory<Int, Models.SuperHero>() {

    fun setFilter(filter: String) {
        dataSource.setFilter(filter)
    }

    override fun create(): DataSource<Int, Models.SuperHero> {
            return dataSource
    }

}