package com.example.androidmasterproject.di

import com.example.androidmasterproject.viewmodel.MovieViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MovieViewModel(get())
    }
}