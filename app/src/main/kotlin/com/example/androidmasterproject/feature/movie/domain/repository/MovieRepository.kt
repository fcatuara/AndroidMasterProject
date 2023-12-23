package com.example.androidmasterproject.feature.movie.domain.repository

import com.example.androidmasterproject.core.network.adapter.ApiCall
import com.example.androidmasterproject.feature.movie.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<ApiCall<List<Movie>>>
}