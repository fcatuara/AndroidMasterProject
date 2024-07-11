package com.example.androidmasterproject.core.di

import com.example.androidmasterproject.feature.movie.data.repository.MovieRepositoryImpl
import com.example.androidmasterproject.feature.movie.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {

    @Binds
    fun bindsMovieRepository(
        movieRepositoryImpl: MovieRepositoryImpl,
    ): MovieRepository

}