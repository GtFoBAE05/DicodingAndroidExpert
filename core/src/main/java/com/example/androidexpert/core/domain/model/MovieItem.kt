package com.example.androidexpert.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieItem(
    val movieId:Int,
    val title:String,
    val overview:String,
    val posterPath:String,
    val releaseDate:String,
    val language:String
) : Parcelable