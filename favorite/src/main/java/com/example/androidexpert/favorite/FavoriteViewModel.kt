package com.example.androidexpert.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.androidexpert.core.domain.usecase.MovieUseCase

class FavoriteViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun getFavByMovie() = movieUseCase.getFavoriteMovie().asLiveData()

}