package com.example.androidexpert.core.data.source.local

import com.example.androidexpert.core.data.source.local.entity.MovieEntity
import com.example.androidexpert.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieDao: MovieDao) {

    fun getFavoriteMovie(): Flow<List<MovieEntity>> = movieDao.getFavoriteMovie()

    fun getFavoriteUserByMovieId(movieId: Int) = movieDao.getFavoriteUserByMovieId(movieId)

    suspend fun insertFavoriteMovie(movieEntity: MovieEntity) = movieDao.insertMovie(movieEntity)

    suspend fun deleteFavoriteMovie(movieEntity: MovieEntity) = movieDao.deleteFavouriteMovie(movieEntity)



}