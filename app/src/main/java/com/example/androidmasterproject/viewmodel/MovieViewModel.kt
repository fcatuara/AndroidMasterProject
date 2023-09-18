package com.example.androidmasterproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidmasterproject.data.model.Movies
import com.example.androidmasterproject.data.service.api.ResultOf
import com.example.androidmasterproject.data.service.repository.RepositoryFactory
import com.example.androidmasterproject.utils.extension.print
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.lang.Exception


class MovieViewModel constructor(
    private val repository: RepositoryFactory
) : ViewModel() {

    private var moviesTopRated = MutableLiveData<ResultOf<Movies>>()
    val moviesTopRatedLiveData: LiveData<ResultOf<Movies>> get() = moviesTopRated

    private var moviesPopular = MutableLiveData<ResultOf<Movies>>()
    val moviesPopularLiveData: LiveData<ResultOf<Movies>> get() = moviesPopular

    private var moviesUpcoming = MutableLiveData<ResultOf<Movies>>()
    val moviesUpcomingLiveData: LiveData<ResultOf<Movies>> get() = moviesUpcoming




    fun getTopRated() {
        print("MovieViewModel - get Top Rated ")
        viewModelScope.launch(IO) {
            moviesTopRated.postValue(ResultOf.Loading)
            try {
                val response = repository.selectRepository().getTopRatedMovies()
                moviesTopRated.postValue(ResultOf.Success(data = response))
            } catch (exception: Exception) {
                moviesTopRated.postValue(exception.let {
                    ResultOf.Failure(message = it.message, throwable = it)
                })
            }
        }
    }

    fun getPopular() {
        print("MovieViewModel - get Popular ")
        viewModelScope.launch(IO) {
            moviesPopular.postValue(ResultOf.Loading)
            try {
                val response = repository.selectRepository().getPopularMovies()
                moviesPopular.postValue(ResultOf.Success(data = response))
            } catch (exception: Exception) {
                moviesPopular.postValue(exception.let {
                    ResultOf.Failure(message = it.message, throwable = it)
                })
            }
        }
    }

    fun getUpcoming() {
        print("MovieViewModel - get Upcoming")
        viewModelScope.launch(IO) {
            moviesUpcoming.postValue(ResultOf.Loading)
            try {
                val response = repository.selectRepository().getUpcomingMovies()
                moviesUpcoming.postValue(ResultOf.Success(data = response))
            } catch (exception: Exception) {
                moviesUpcoming.postValue(exception.let {
                    ResultOf.Failure(message = it.message, throwable = it)
                })
            }
        }
    }
}