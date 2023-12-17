package com.example.androidexpert.core.domain.usecase

import com.example.androidexpert.core.data.Resource
import com.example.androidexpert.core.domain.model.MovieItem
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getPopularMovie(): Flow<Resource<List<MovieItem>>>
    fun getFavoriteMovie(): Flow<List<MovieItem>>
    fun getFavoriteUserByMovieId(movieId: Int) : Flow<MovieItem>
    suspend fun insertFavoriteMovie(movieItem: MovieItem)
    suspend fun deleteFavoriteMovie(movieItem: MovieItem)
}