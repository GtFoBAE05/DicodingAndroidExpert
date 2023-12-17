package com.example.androidexpert.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.androidexpert.core.domain.model.MovieItem
import com.example.androidexpert.core.domain.usecase.MovieUseCase
import kotlinx.coroutines.launch

class DetailActivityViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {


    fun getFavByMovie() = movieUseCase.getFavoriteMovie().asLiveData()

    fun addFavMovie(movieItem: MovieItem)= viewModelScope.launch {
        movieUseCase.insertFavoriteMovie(movieItem)
    }

    fun deleteFavMovie(movieItem: MovieItem)= viewModelScope.launch {
        movieUseCase.deleteFavoriteMovie(movieItem)
    }
}