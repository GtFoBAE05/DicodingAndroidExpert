package com.example.androidexpert.core.data.source.remote

import android.util.Log
import com.example.androidexpert.core.data.source.remote.network.ApiResponse
import com.example.androidexpert.core.data.source.remote.network.ApiService
import com.example.androidexpert.core.data.source.remote.response.ListPopularMovieResponse
import com.example.androidexpert.core.data.source.remote.response.PopularMovieResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllPopularMovies(): Flow<ApiResponse<List<PopularMovieResult>>> {
        return flow {
            val response = apiService.getPopularMovie()
            val dataArray = response.results
            Log.e("TAG", "getAllPopularMovies: " + dataArray, )

            if (dataArray.isNotEmpty()) {
                emit(ApiResponse.Success(response.results))
            } else {
                emit(ApiResponse.Empty)
            }
        }.catch { e ->
            emit(ApiResponse.Error(e.toString()))
            Log.e("RemoteDataSource", e.toString())
        }.flowOn(Dispatchers.IO)
    }


}