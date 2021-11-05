package com.example.androidmasterproject.di

import com.example.androidmasterproject.data.service.api.ApiService
import com.example.androidmasterproject.data.service.repository.Repository
import com.example.androidmasterproject.data.service.repository.RepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(apiService: ApiService): Repository {
        return  RepositoryImp(apiService)
    }
}