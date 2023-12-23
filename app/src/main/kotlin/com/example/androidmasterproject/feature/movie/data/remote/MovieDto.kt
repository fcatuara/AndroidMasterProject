package com.example.androidmasterproject.feature.movie.data.remote

import com.google.gson.annotations.SerializedName

data class MovieDto(

    @SerializedName("title")
    val title: String? = null
)
