package com.example.androidexpert.core.data.source.remote.network

import com.example.androidexpert.core.data.source.remote.response.ListPopularMovieResponse
import retrofit2.http.GET

interface ApiService {
    @GET("movie/popular?api_key=a3b162c8e11218bf394576739df6b5c7")
    suspend fun getPopularMovie(): ListPopularMovieResponse
}