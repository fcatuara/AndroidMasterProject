package com.example.androidmasterproject.feature.movie.data.remote


import com.example.androidmasterproject.core.network.POPULAR_MOVIES
import com.example.androidmasterproject.core.network.TOP_RATED_MOVIES
import com.example.androidmasterproject.core.network.UPCOMING_MOVIES
import com.example.androidmasterproject.core.network.adapter.ApiCall
import retrofit2.http.GET
import retrofit2.http.Query

/// api service :__ https://api.themoviedb.org/3/genre/movie/list?api_key=0674eefa6fa61be1f3868472e8d4803f
interface MovieApi {

    @GET(TOP_RATED_MOVIES)
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey:String = "0674eefa6fa61be1f3868472e8d4803f",
        @Query("page") page:Int?,
    ): ApiCall<List<MovieDto>>

    @GET(POPULAR_MOVIES)
    suspend fun getPopularMovies(
        @Query("api_key") apiKey:String = "0674eefa6fa61be1f3868472e8d4803f",
        @Query("page") page:Int?,
    ): ApiCall<MovieDto>

    @GET(UPCOMING_MOVIES)
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey:String = "0674eefa6fa61be1f3868472e8d4803f",
        @Query("page") page:Int?,
    ): ApiCall<MovieDto>
}