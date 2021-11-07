package com.example.androidmasterproject.data.service.repository

import com.example.androidmasterproject.data.model.Pokemon

interface Repository {

    suspend fun getPokemon(id: Long): Pokemon

}