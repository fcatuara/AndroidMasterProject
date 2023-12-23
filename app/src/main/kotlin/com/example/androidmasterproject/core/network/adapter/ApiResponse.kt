package com.example.androidmasterproject.core.network.adapter

import java.io.IOException

typealias ApiCall<Body> = ApiResponse<Body, Error>

sealed class ApiResponse<out Body : Any, out Error : Any> {

    data class Success<Body : Any>(val body: Body) : ApiResponse<Body, Nothing>()

    data class ApiError<Error : Any>(val body: Error, val code: Int) : ApiResponse<Nothing, Error>()

    data class NetworkError(val error: IOException) : ApiResponse<Nothing, Nothing>()

    data class UnknownError(val error: Throwable) : ApiResponse<Nothing, Nothing>()
}