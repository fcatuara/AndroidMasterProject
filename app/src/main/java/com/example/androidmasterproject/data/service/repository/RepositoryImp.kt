package com.example.androidmasterproject.data.service.repository

import com.example.androidmasterproject.data.model.Pokemons
import com.example.androidmasterproject.data.service.api.ApiService

class RepositoryImp (private val apiService:ApiService) : Repository {

    override suspend fun getPokemons(limit:Int?): Pokemons{
        return apiService.getPokemon(limit)
    }
}