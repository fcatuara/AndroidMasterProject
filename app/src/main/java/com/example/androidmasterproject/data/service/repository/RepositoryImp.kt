package com.example.androidmasterproject.data.service.repository

import com.example.androidmasterproject.data.model.Pokemon
import com.example.androidmasterproject.data.service.api.ApiService

class RepositoryImp (private val apiService:ApiService) : Repository {

    override suspend fun getPokemon(id: Long): Pokemon {
       return apiService.getPokemon()
    }
}