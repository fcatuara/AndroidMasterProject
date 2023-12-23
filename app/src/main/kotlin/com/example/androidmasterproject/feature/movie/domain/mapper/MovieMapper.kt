package com.example.androidmasterproject.feature.movie.domain.mapper

import com.example.androidmasterproject.core.mapper.Mapper
import com.example.androidmasterproject.feature.movie.data.remote.dto.MovieDto
import com.example.androidmasterproject.feature.movie.domain.model.Movie

class MovieMapper : Mapper<MovieDto, Movie> {

    override fun map(input: MovieDto): Movie {
       return Movie(
            input.title.orEmpty()
        )
    }
}