package com.example.androidmasterproject.data.service.repository

import com.example.androidmasterproject.data.model.Movies
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

    override suspend fun getTopRatedMovies(page: Int?): Movies? {
        var body : Movies?= null
        withContext(Dispatchers.IO) {
            try {
                Timer().schedule(object : TimerTask() {
                    override fun run() {
                        val jsonString = assetUtils.getJsonFromAsset("mock/pokemons.json")
                        val bodyType = object : TypeToken<Movies>() {}.type
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

    override suspend fun getPopularMovies(page: Int?): Movies? {
        TODO("Not yet implemented")
    }

    override suspend fun getUpcomingMovies(page: Int?): Movies? {
        TODO("Not yet implemented")
    }
}