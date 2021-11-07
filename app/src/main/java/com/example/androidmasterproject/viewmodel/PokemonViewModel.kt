package com.example.androidmasterproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidmasterproject.data.model.Pokemon
import com.example.androidmasterproject.data.service.repository.Repository
import com.example.androidmasterproject.utils.ResultOf
import com.example.androidmasterproject.utils.extension.print
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private var pokemon = MutableLiveData<ResultOf<Pokemon>>()
    val pokemonLiveData: LiveData<ResultOf<Pokemon>> get() = pokemon


    fun getPokemon(id: Long) {
        viewModelScope.launch(IO) {
            pokemon.value = ResultOf.Loading
            try {
                val response = repository.getPokemon(id)
                pokemon.value = ResultOf.Success(data = response)
            } catch (exception: Exception) {
                pokemon.value = exception.let {
                    ResultOf.Failure(message = it.message, throwable = it)
                }
            }
        }
    }
}