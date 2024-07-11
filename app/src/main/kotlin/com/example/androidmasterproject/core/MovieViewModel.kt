package com.example.androidmasterproject.core

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidmasterproject.feature.movie.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val _movieDetailUiState = MutableStateFlow("")
    val movieDetailUiState: StateFlow<String> = _movieDetailUiState.asStateFlow()

    fun getMovieDetail() {
        viewModelScope.launch {
            repository.getMovieById(id = 22)
                .collect {
                    _movieDetailUiState.value = it.title
                }
        }
    }
}