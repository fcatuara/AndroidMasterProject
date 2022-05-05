package com.example.androidmasterproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidmasterproject.data.model.Pokemons
import com.example.androidmasterproject.data.service.repository.Repository
import com.example.androidmasterproject.data.service.api.ResultOf
import com.example.androidmasterproject.data.service.repository.RepositoryFactory
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.lang.Exception


class PokemonViewModel constructor(
    private val repository: RepositoryFactory
) : ViewModel() {

    private var pokemon = MutableLiveData<ResultOf<Pokemons>>()
    val pokemonLiveData: LiveData<ResultOf<Pokemons>> get() = pokemon


    fun getPokemon() {
        viewModelScope.launch(IO) {
            pokemon.postValue(ResultOf.Loading)
            try {
                val response = repository.selectRepository().getPokemons()
                pokemon.postValue(ResultOf.Success(data = response))
            } catch (exception: Exception) {
                pokemon.postValue(exception.let {
                    ResultOf.Failure(message = it.message, throwable = it)
                })
            }
        }
    }
}