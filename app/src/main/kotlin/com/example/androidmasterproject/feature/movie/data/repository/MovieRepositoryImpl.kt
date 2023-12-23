package com.example.androidmasterproject.feature.movie.data.repository

import com.example.androidmasterproject.core.mapper.Mapper
import com.example.androidmasterproject.core.network.adapter.ApiCall
import com.example.androidmasterproject.core.network.adapter.ApiResponse
import com.example.androidmasterproject.feature.movie.data.local.MovieLocalDataSource
import com.example.androidmasterproject.feature.movie.data.remote.MovieDto
import com.example.androidmasterproject.feature.movie.data.remote.MovieRemoteDataSource
import com.example.androidmasterproject.feature.movie.domain.model.Movie
import com.example.androidmasterproject.feature.movie.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class MovieRepositoryImpl (
    private val remoteSource: MovieRemoteDataSource,
    private val localSource: MovieLocalDataSource,
    private val movieDataMapper: Mapper<MovieDto, Movie>
) : MovieRepository {

    override suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<ApiCall<List<Movie>>> {
        remoteSource.getMovies().map {
            if (it is ApiResponse.Success){
                it.body.map { item -> movieDataMapper.map(item) }
            }
        }
        return flowOf()
    }
}