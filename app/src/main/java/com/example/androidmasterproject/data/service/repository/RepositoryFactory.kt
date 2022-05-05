package com.example.androidmasterproject.data.service.repository

import com.example.androidmasterproject.BuildConfig

class RepositoryFactory(
    private val repositoryMocked: RepositoryMocked,
    private val repositoryNetwork: RepositoryNetwork
) {
    fun selectRepository() = if (BuildConfig.IS_MOCKED_REPOSITORY)
        repositoryMocked
    else
        repositoryNetwork
}