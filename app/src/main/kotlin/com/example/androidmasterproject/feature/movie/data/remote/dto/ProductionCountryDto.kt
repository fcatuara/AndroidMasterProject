package com.example.androidmasterproject.feature.movie.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ProductionCountryDto(
    @SerializedName("iso_3166_1") val iso: String? = null,
    @SerializedName("name") val name: String? = null,
)