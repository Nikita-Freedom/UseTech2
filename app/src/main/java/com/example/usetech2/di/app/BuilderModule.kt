package com.example.usetech2.di.app

import com.example.usetech2.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module()
abstract class BuilderModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

}