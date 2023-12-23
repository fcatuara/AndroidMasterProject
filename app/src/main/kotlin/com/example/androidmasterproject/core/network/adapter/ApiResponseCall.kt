package com.example.androidmasterproject.core.network.adapter

import okhttp3.Request
import okhttp3.ResponseBody
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

internal class ApiResponseCall<Body : Any, Error : Any>(
    private val delegate: Call<Body>,
    private val errorConverter: Converter<ResponseBody, Error>
) : Call<ApiResponse<Body, Error>> {

    override fun enqueue(callback: Callback<ApiResponse<Body, Error>>) {
        return delegate.enqueue(object : Callback<Body> {
            override fun onResponse(call: Call<Body>, response: Response<Body>) {
                handleOnResponse(callback, response)
            }

            override fun onFailure(call: Call<Body>, throwable: Throwable) {
                handleOnFailure(callback, throwable)
            }

        })
    }

    private fun handleOnFailure(
        callback: Callback<ApiResponse<Body, Error>>,
        throwable: Throwable
    ) {
        callback.onResponse(
            this@ApiResponseCall, Response.success(
                when (throwable) {
                    is IOException -> ApiResponse.NetworkError(throwable)
                    is HttpException -> ApiResponse.NetworkError(
                        IOException(
                            throwable.message(),
                            throwable
                        )
                    )

                    else -> ApiResponse.UnknownError(throwable)
                }
            )
        )
    }

    private fun handleOnResponse(
        callback: Callback<ApiResponse<Body, Error>>,
        response: Response<Body>
    ) {
        val body = response.body()
        val code = response.code()
        val error = response.errorBody()

        if (response.isSuccessful) {
            callback.onResponse(
                this@ApiResponseCall,
                if (body != null) Response.success(code, ApiResponse.Success(body))
                else Response.success(ApiResponse.UnknownError(Throwable()))
            )
        } else {
            val errorBody = when {
                error == null -> null
                error.contentLength() == 0L -> null
                else -> try {
                    errorConverter.convert(error)
                } catch (ex: Exception) {
                    null
                }
            }

            callback.onResponse(
                this@ApiResponseCall,
                if (errorBody != null) Response.success(
                    ApiResponse.ApiError(
                        errorBody,
                        code
                    )
                ) else Response.success(ApiResponse.UnknownError(Throwable()))
            )
        }
    }

    override fun clone(): Call<ApiResponse<Body, Error>> {
        return ApiResponseCall(delegate.clone(), errorConverter)
    }

    override fun execute(): Response<ApiResponse<Body, Error>> {
        throw UnsupportedOperationException("ApiResponseCall doesn't support execute")
    }

    override fun isExecuted() = delegate.isExecuted

    override fun cancel() = delegate.cancel()

    override fun isCanceled() = delegate.isCanceled

    override fun request(): Request = delegate.request()

    override fun timeout(): Timeout = delegate.timeout()
}