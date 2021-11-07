package com.example.androidmasterproject.data.service.repository

import com.example.androidmasterproject.data.model.Pokemon
import com.example.androidmasterproject.utils.ResultOf

interface Repository {

   suspend fun getPokemon(id: Long): Pokemon
}