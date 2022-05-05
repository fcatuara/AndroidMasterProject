package com.example.androidmasterproject.data.service.api

import com.example.androidmasterproject.data.model.Pokemons
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(urlPokemonsList)
    suspend fun getPokemon(
        @Query("limit") limit:Int? = 30
    ): Pokemons
}

