package com.example.androidmasterproject.data.service.repository

import com.example.androidmasterproject.data.model.Movies

interface Repository {

    suspend fun getTopRatedMovies(page:Int? = 1): Movies?
    suspend fun getPopularMovies(page:Int? = 1): Movies?
    suspend fun getUpcomingMovies(page:Int? = 1): Movies?

}