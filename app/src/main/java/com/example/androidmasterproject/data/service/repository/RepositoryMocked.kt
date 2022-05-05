package com.example.androidmasterproject.data.service.repository

import com.example.androidmasterproject.data.model.Pokemons
import com.example.androidmasterproject.utils.AssetUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

/**
 * you can fetch mocked data from asset/mock folder
 */
class RepositoryMocked (private val assetUtils: AssetUtils) : Repository{

    override suspend fun getPokemons(limit: Int?): Pokemons? {
        var body : Pokemons?= null
        withContext(Dispatchers.IO) {
            try {
                Timer().schedule(object : TimerTask() {
                    override fun run() {
                        val jsonString = assetUtils.getJsonFromAsset("mock/pokemons.json")
                        val bodyType = object : TypeToken<Pokemons>() {}.type
                        body =  Gson().fromJson(jsonString, bodyType)
                    }
                }, 3000)

                return@withContext
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return body
    }
}