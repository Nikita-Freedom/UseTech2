package com.example.usetech2.di.app

import com.example.usetech2.ui.superheroesbiography.SuperheroBiography
import com.example.usetech2.ui.superheroeslist.SuperheroesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun contributePhotosFragment(): SuperheroesFragment

    @ContributesAndroidInjector
    abstract fun contributePhotoDetailFragment(): SuperheroBiography

}