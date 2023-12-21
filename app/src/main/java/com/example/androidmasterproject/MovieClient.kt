package com.example.androidmasterproject

import javax.inject.Inject

class MovieClient @Inject constructor(
    private val movieService: MovieService,
) {

    //TODO : return ApiResponse<MovieResponse>
    suspend fun fetchMovieList(page: Int): Movies? =
        movieService.getTopRatedMovies(page = 1)
}