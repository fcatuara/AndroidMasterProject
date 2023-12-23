package com.example.androidmasterproject.feature.movie.data.remote


import com.example.androidmasterproject.core.network.MOVIE_DETAIL
import com.example.androidmasterproject.core.network.adapter.ApiCall
import com.example.androidmasterproject.feature.movie.data.remote.dto.MovieDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/// api service :__ https://api.themoviedb.org/3/genre/movie/list?api_key=0674eefa6fa61be1f3868472e8d4803f
interface MovieApi {

    @GET(MOVIE_DETAIL)
    suspend fun getMovieById(
        @Query("api_key") apiKey:String = "0674eefa6fa61be1f3868472e8d4803f",
        @Path("movie_id") id:Int,
    ): ApiCall<MovieDto>
}