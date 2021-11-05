package com.example.androidmasterproject.data.service.api

import com.example.androidmasterproject.data.model.Pokemon
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface ApiService {

    @GET("api/pokemon")
    suspend fun getPokemon(): Pokemon
}

