package com.example.androidmasterproject

data class MoviesApiModel(
    val page: Int?,
    val results: List<Result>?,
    val total_pages: Int?,
    val total_results: Int?
)