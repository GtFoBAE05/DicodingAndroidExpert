//package com.example.androidexpert.ui.favorite
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.asLiveData
//import androidx.lifecycle.viewModelScope
//import com.example.androidexpert.core.domain.model.MovieItem
//import com.example.androidexpert.core.domain.usecase.MovieUseCase
//import kotlinx.coroutines.launch
//
//class FavoriteViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
//    fun getFavByMovie() = movieUseCase.getFavoriteMovie().asLiveData()
//
//}