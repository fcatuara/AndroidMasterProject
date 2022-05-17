package com.example.androidmasterproject.data.service.repository

import com.example.androidmasterproject.data.model.Pokemons

interface Repository {

    suspend fun getPokemons(limit:Int? = null,offset:Int? = null): Pokemons?

}