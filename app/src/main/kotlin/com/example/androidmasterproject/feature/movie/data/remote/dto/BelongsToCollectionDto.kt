package com.example.androidmasterproject.feature.movie.data.remote.dto

import com.google.gson.annotations.SerializedName

data class BelongsToCollectionDto(
    @SerializedName("backdrop_path") val backdropPath: Boolean? = null,
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("poster_path") val posterPath: String? = null,
)