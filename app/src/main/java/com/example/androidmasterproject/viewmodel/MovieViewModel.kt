package com.example.androidmasterproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidmasterproject.data.model.Movies
import com.example.androidmasterproject.data.service.api.ResultOf
import com.example.androidmasterproject.data.service.repository.RepositoryFactory
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.lang.Exception


class MovieViewModel constructor(
    private val repository: RepositoryFactory
) : ViewModel() {

    private var movies = MutableLiveData<ResultOf<Movies>>()
    val moviesLiveData: LiveData<ResultOf<Movies>> get() = movies


    fun getPokemon() {
        viewModelScope.launch(IO) {
            movies.postValue(ResultOf.Loading)
            try {
                val response = repository.selectRepository().getTopRatedMovies()
                movies.postValue(ResultOf.Success(data = response))
            } catch (exception: Exception) {
                movies.postValue(exception.let {
                    ResultOf.Failure(message = it.message, throwable = it)
                })
            }
        }
    }
}