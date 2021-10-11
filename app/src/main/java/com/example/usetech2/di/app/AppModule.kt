package com.example.usetech2.di.app

import android.content.Context
import com.example.usetech2.App
import com.example.usetech2.data.extractor.NetworkJobExecutor
import com.example.usetech2.domain.executer.PostExecutionThread
import com.example.usetech2.domain.executer.UseCaseExecutor
import com.example.usetech2.domain.repository.ConnectivityManager
import com.example.usetech2.ui.executer.UiThreadExecutor
import com.example.usetech2.util.ConnectivityManagerImp
import dagger.Module
import dagger.Provides
import com.example.usetech2.di.scope.ForApplication
import javax.inject.Singleton

@Module
object AppModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideUseCaseExecutor(): UseCaseExecutor {
        return NetworkJobExecutor()
    }

    @Provides
    @JvmStatic
    @Singleton
    fun postExecutionThread(): PostExecutionThread = UiThreadExecutor()


    @Provides
    @JvmStatic
    @ForApplication
    fun provideContext(app: App): Context = app.applicationContext

    @Provides
    @JvmStatic
    @Singleton
    fun provideConnectivityManager(connectivityManagerImp: ConnectivityManagerImp)
            : ConnectivityManager = connectivityManagerImp
}
