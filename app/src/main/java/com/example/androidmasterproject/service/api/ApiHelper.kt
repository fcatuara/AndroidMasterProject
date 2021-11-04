package com.example.androidmasterproject.service.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getPokemon() = apiService.getPokemon()
}