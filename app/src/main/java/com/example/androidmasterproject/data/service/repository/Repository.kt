package com.example.androidmasterproject.data.service.repository

import com.example.androidmasterproject.data.model.Movies

interface Repository {

    suspend fun getTopRatedMovies(page:Int? = 1): Movies?

}