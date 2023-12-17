package com.example.androidexpert.core.utils

import com.example.androidexpert.core.data.source.local.entity.MovieEntity
import com.example.androidexpert.core.data.source.remote.response.PopularMovieResult
import com.example.androidexpert.core.domain.model.MovieItem

object DataMapper {

    fun mapEntityToDomain(data : List<MovieEntity>) : List<MovieItem> =
        data.map {
            MovieItem(
                movieId = it.movieId ?: 0,
                title = it.title ?: "",
                overview = it.overview ?: "",
                posterPath = it.posterPath ?: "",
                releaseDate = it.releaseDate ?: "",
                language = it.language ?: ""
            )
        }

    fun mapSingleEntityToDomain(data : MovieEntity) : MovieItem =
         MovieItem(
             movieId = data.movieId ?: 0,
             title = data.title.orEmpty(),
             overview = data.overview.orEmpty(),
             posterPath = data.posterPath.orEmpty(),
             releaseDate = data.releaseDate.orEmpty(),
             language = data.language.orEmpty()
            )


    fun mapResponseToDomain(data: List<PopularMovieResult>) : List<MovieItem>{
        val movieList = ArrayList<MovieItem>()
        data.map {
            val movieItem = MovieItem(
                movieId = it.id ?: 0,
                title = it.title ?: "",
                overview = it.overview ?: "",
                posterPath = it.posterPath ?: "",
                releaseDate = it.releaseDate ?: "",
                language = it.originalLanguage ?: ""
            )
            movieList.add(movieItem)
        }
        return movieList
    }

    fun mapDomainToEntity(data : MovieItem) = MovieEntity(
        movieId = data.movieId,
        title = data.title ?: "",
        overview = data.overview ?: "",
        posterPath = data.posterPath ?: "",
        releaseDate = data.releaseDate ?: "",
        language = data.language ?: ""
    )
}