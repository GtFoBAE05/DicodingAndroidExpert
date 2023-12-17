package com.example.androidexpert.core.domain.repository

import com.example.androidexpert.core.data.Resource
import com.example.androidexpert.core.domain.model.MovieItem
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getPopularMovie(): Flow<Resource<List<MovieItem>>>

    fun getFavoriteMovie(): Flow<List<MovieItem>>

    fun getFavoriteUserByMovieId(movieId: Int) : Flow<MovieItem>

    suspend fun insertFavoriteMovie(movie: MovieItem)

    suspend fun deleteFavoriteMovie(movie: MovieItem)

}