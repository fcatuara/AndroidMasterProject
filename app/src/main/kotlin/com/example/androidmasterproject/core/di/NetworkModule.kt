package com.example.androidmasterproject.core.di

import com.example.androidmasterproject.BuildConfig
import com.example.androidmasterproject.feature.movie.data.remote.MovieApi
import com.example.androidmasterproject.core.network.interceptor.HttpRequestInterceptor
import com.example.androidmasterproject.core.network.adapter.ApiResponseAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(HttpRequestInterceptor())
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        apiResponseAdapterFactory: ApiResponseAdapterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
             //TODO:[Retrofit] what's about MoshiConverterFactory ?
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(apiResponseAdapterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieService(retrofit: Retrofit): MovieApi =
        retrofit.create(MovieApi::class.java)
}