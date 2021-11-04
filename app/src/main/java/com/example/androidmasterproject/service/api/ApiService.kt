package com.example.androidmasterproject.service.api

import com.example.androidmasterproject.service.model.Pokemon
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

    companion object {
        fun create(): ApiService {

            val requestInterceptor = Interceptor { chain ->
                val url = chain.request()
                    .url
                    .newBuilder()
                    .build()

                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient: OkHttpClient =
                OkHttpClient.Builder()
                    .addInterceptor(requestInterceptor)
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .build()


            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("BASE_URL")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)

        }
    }
}

