package com.example.usetech2.di.viewmodel

import androidx.lifecycle.ViewModel
import com.example.usetech2.ui.superheroesbiography.SuperheroBiographyViewModel
import com.example.usetech2.ui.superheroeslist.SuperheroesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(clazz = SuperheroesViewModel::class)
    abstract fun bindPhotosViewModel(viewModel: SuperheroesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(clazz = SuperheroBiographyViewModel::class)
    abstract fun bindPhotoDetailViewModel(viewModel: SuperheroBiographyViewModel): ViewModel

}