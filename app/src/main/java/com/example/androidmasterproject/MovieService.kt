package com.example.androidmasterproject

import com.example.androidmasterproject.network.ApiCall
import retrofit2.http.GET
import retrofit2.http.Query

/// api service :__ https://api.themoviedb.org/3/genre/movie/list?api_key=0674eefa6fa61be1f3868472e8d4803f
interface MovieService {

    @GET(topRatedMovies)
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey:String = "0674eefa6fa61be1f3868472e8d4803f",
        @Query("page") page:Int?,
    ): ApiCall<MoviesApiModel>

    @GET(popularMovies)
    suspend fun getPopularMovies(
        @Query("api_key") apiKey:String = "0674eefa6fa61be1f3868472e8d4803f",
        @Query("page") page:Int?,
    ): ApiCall<MoviesApiModel>

    @GET(upcomingMovies)
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey:String = "0674eefa6fa61be1f3868472e8d4803f",
        @Query("page") page:Int?,
    ): ApiCall<MoviesApiModel>
}