package com.example.androidmasterproject.data.service.repository

import com.example.androidmasterproject.data.service.api.ApiService
import javax.inject.Inject

class Repository @Inject constructor(
    private val webService:ApiService
) {

    suspend fun getUser() = webService.getPokemon()
}