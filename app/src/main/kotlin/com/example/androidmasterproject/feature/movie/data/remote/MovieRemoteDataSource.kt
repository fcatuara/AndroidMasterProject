package com.example.androidmasterproject.feature.movie.data.remote

import com.example.androidmasterproject.core.network.adapter.ApiCall
import com.example.androidmasterproject.feature.movie.data.remote.dto.MovieDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(
    private val api: MovieApi
) {

    suspend fun getMovieById(): Flow<ApiCall<MovieDto>> {
        return flow {
            emit(api.getMovieById(id = 21))
        }
    }
}