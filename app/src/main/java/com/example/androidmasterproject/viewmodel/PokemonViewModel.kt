package com.example.androidmasterproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidmasterproject.service.model.Pokemon
import com.example.androidmasterproject.service.repository.Repository
import com.example.androidmasterproject.utils.ResultOf

class PokemonViewModel(private val repository: Repository) : ViewModel()  {

    private var pokemons = MutableLiveData<ResultOf<Pokemon>>()
    val pokemonLiveData: LiveData<ResultOf<Pokemon>>
        get() = pokemons

}