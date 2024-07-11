package com.example.androidmasterproject.feature.movie.data.repository

import com.example.androidmasterproject.core.mapper.Mapper
import com.example.androidmasterproject.core.network.adapter.ApiResponse
import com.example.androidmasterproject.feature.movie.data.remote.MovieRemoteDataSource
import com.example.androidmasterproject.feature.movie.data.remote.dto.MovieDto
import com.example.androidmasterproject.feature.movie.domain.model.Movie
import com.example.androidmasterproject.feature.movie.domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteSource: MovieRemoteDataSource,
    private val movieDataMapper: Mapper<MovieDto, Movie>
) : MovieRepository {

    override suspend fun getMovieById(
        id: Int
    ): Flow<Movie> {
        return remoteSource.getMovieById().map {
            when (it) {
                is ApiResponse.Success ->
                    movieDataMapper.map(it.body)

                else -> {
                    Movie(title = "Error")
                }
            }
        }.flowOn(Dispatchers.IO)
    }
}