package com.example.androidexpert.di

import com.example.androidexpert.core.domain.usecase.MovieInteractor
import com.example.androidexpert.core.domain.usecase.MovieUseCase
import com.example.androidexpert.ui.detail.DetailActivityViewModel
import com.example.androidexpert.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailActivityViewModel(get()) }
//    viewModel { FavoriteViewModel(get()) }
}