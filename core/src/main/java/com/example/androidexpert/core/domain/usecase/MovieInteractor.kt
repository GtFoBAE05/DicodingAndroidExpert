package com.example.androidexpert.core.domain.usecase

import com.example.androidexpert.core.domain.model.MovieItem
import com.example.androidexpert.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class MovieInteractor(private val movieRepository: IMovieRepository): MovieUseCase {

    override fun getPopularMovie() = movieRepository.getPopularMovie()

    override fun getFavoriteMovie() = movieRepository.getFavoriteMovie()
    override fun getFavoriteUserByMovieId(movieId: Int) = movieRepository.getFavoriteUserByMovieId(movieId)

    override suspend fun insertFavoriteMovie(movieItem: MovieItem) = movieRepository.insertFavoriteMovie(movieItem)

    override suspend fun deleteFavoriteMovie(movieItem: MovieItem) = movieRepository.deleteFavoriteMovie(movieItem)

}