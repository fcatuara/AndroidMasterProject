package com.example.androidmasterproject

import com.example.androidmasterproject.network.ApiCall
import javax.inject.Inject

class MovieClient @Inject constructor(
    private val movieService: MovieService,
) {

    suspend fun fetchMovieList(page: Int): ApiCall<MoviesApiModel> =
        movieService.getTopRatedMovies(page = 1)
}