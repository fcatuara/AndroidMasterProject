package com.example.androidmasterproject.feature.movie.domain.repository

import com.example.androidmasterproject.feature.movie.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

     suspend fun getMovieById(
        id: Int
    ): Flow<Movie>
}