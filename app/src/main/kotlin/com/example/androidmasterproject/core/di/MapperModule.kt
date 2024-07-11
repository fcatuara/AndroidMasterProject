package com.example.androidmasterproject.core.di

import com.example.androidmasterproject.core.mapper.Mapper
import com.example.androidmasterproject.feature.movie.data.remote.dto.MovieDto
import com.example.androidmasterproject.feature.movie.domain.mapper.MovieMapper
import com.example.androidmasterproject.feature.movie.domain.model.Movie
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object MapperModule {

    @Provides
    @Singleton
    fun provideMovieMapper(): Mapper<MovieDto, Movie> = MovieMapper()
}