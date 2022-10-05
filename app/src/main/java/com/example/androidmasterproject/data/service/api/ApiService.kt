package com.example.androidmasterproject.data.service.api

import com.example.androidmasterproject.data.model.Movies
import retrofit2.http.GET
import retrofit2.http.Query


/// api service :__ https://api.themoviedb.org/3/genre/movie/list?api_key=0674eefa6fa61be1f3868472e8d4803f

interface ApiService {

    @GET(topRatedMovies)
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey:String = "0674eefa6fa61be1f3868472e8d4803f",
        @Query("page") page:Int?,
        ): Movies?

}

