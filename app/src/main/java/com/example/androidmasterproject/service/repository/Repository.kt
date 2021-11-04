package com.example.androidmasterproject.service.repository

import com.example.androidmasterproject.service.api.ApiService

class Repository(private val webService:ApiService) {

    suspend fun getUser() = webService.getPokemon()
}