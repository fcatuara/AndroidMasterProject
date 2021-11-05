package com.example.androidmasterproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidmasterproject.data.model.Pokemon
import com.example.androidmasterproject.data.service.repository.Repository
import com.example.androidmasterproject.utils.ResultOf
import com.example.androidmasterproject.utils.extension.print
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private var pokemons = MutableLiveData<ResultOf<Pokemon>>()
    val pokemonLiveData: LiveData<ResultOf<Pokemon>>
        get() = pokemons

    init {
        repository.print("repository instance")
    }


}