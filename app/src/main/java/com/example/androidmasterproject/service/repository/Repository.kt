package com.example.androidmasterproject.service.repository

import com.example.androidmasterproject.service.api.ApiHelper

class Repository(private val apiHelper: ApiHelper) {
    suspend fun getUser() = apiHelper.getPokemon()
}