package com.example.androidmasterproject.data.service.repository

import com.example.androidmasterproject.data.model.Movies
import com.example.androidmasterproject.data.service.api.ApiService
import com.example.androidmasterproject.utils.extension.print

class RepositoryNetwork (private val apiService:ApiService) : Repository {

    override suspend fun getTopRatedMovies(page:Int?): Movies? {
        print("RepositoryNetwork - get Top Rated Movies ")
        return apiService.getTopRatedMovies(page = page)
    }

    override suspend fun getPopularMovies(page: Int?): Movies? {
        print("RepositoryNetwork - get Popular Movies ")
        return apiService.getPopularMovies(page = page)
    }

    override suspend fun getUpcomingMovies(page: Int?): Movies? {
        print("RepositoryNetwork - get Upcoming Movies ")
        return apiService.getUpcomingMovies(page = page)
    }
}