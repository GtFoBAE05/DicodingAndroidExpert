package com.example.androidexpert.core.data

import com.example.androidexpert.core.data.source.local.LocalDataSource
import com.example.androidexpert.core.data.source.remote.RemoteDataSource
import com.example.androidexpert.core.data.source.remote.network.ApiResponse
import com.example.androidexpert.core.domain.model.MovieItem
import com.example.androidexpert.core.domain.repository.IMovieRepository
import com.example.androidexpert.core.utils.AppExecutors
import com.example.androidexpert.core.utils.DataMapper
import com.example.androidexpert.core.utils.DataMapper.mapResponseToDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class MovieRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
) : IMovieRepository {
    override fun getPopularMovie(): Flow<Resource<List<MovieItem>>> = flow {
        emit(Resource.Loading())
        val result = remoteDataSource.getAllPopularMovies().first()
        when (result) {
            is ApiResponse.Success -> {
                val movieItems = mapResponseToDomain(result.data)
                emit(Resource.Success(movieItems))
            }
            is ApiResponse.Error -> {
                emit(Resource.Error(result.errorMessage))
            }
            is ApiResponse.Empty -> {
                emit(Resource.Error("Empty response"))
            }
        }
    }.flowOn(Dispatchers.IO)


    override fun getFavoriteMovie(): Flow<List<MovieItem>> {
        return localDataSource.getFavoriteMovie().map {
            DataMapper.mapEntityToDomain(it)
        }
    }

    override fun getFavoriteUserByMovieId(movieId: Int): Flow<MovieItem> {
        return localDataSource.getFavoriteUserByMovieId(movieId).map { movieEntity ->
                DataMapper.mapSingleEntityToDomain(movieEntity)
        }
    }

    override suspend fun insertFavoriteMovie(movie: MovieItem) {
        val data = DataMapper.mapDomainToEntity(movie)
        localDataSource.insertFavoriteMovie(data)

    }

    override suspend fun deleteFavoriteMovie(movie: MovieItem) {
        val data = DataMapper.mapDomainToEntity(movie)
        localDataSource.deleteFavoriteMovie(data)
    }

}