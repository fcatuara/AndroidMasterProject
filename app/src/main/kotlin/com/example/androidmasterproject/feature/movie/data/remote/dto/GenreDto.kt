package com.example.androidmasterproject.feature.movie.data.remote.dto

import com.google.gson.annotations.SerializedName

data class GenreDto(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
)