package com.example.androidmasterproject.data.service.repository

import com.example.androidmasterproject.data.model.Movies
import com.example.androidmasterproject.data.service.api.ApiService

class RepositoryNetwork (private val apiService:ApiService) : Repository {

    override suspend fun getTopRatedMovies(page:Int?): Movies? {
        return apiService.getTopRatedMovies(page = page)
    }
}