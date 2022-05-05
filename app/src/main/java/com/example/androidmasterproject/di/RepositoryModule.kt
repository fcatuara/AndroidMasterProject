package com.example.androidmasterproject.di

import com.example.androidmasterproject.data.service.repository.RepositoryFactory
import com.example.androidmasterproject.data.service.repository.RepositoryNetwork
import com.example.androidmasterproject.data.service.repository.RepositoryMocked
import org.koin.dsl.module


val repoModule = module {
    single {
        RepositoryNetwork(get())
        RepositoryMocked(get())
        RepositoryFactory(get(),get())
    }
}

