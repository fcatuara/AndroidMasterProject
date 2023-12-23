package com.example.androidmasterproject.feature.movie.data.remote

import com.example.androidmasterproject.core.network.adapter.ApiCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(
    private val api: MovieApi
) {

    suspend fun getMovies(): Flow<ApiCall<List<MovieDto>>> {
        return flow {
            emit(api.getTopRatedMovies(page = 0))
        }
    }
}