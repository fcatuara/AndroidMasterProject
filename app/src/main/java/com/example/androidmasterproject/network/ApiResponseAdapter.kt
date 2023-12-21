package com.example.androidmasterproject.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Converter
import java.lang.reflect.Type

class ApiResponseAdapter<Body : Any, Error : Any>(
    private val successType: Type,
    private val errorBodyConverter: Converter<ResponseBody, Error>
) : CallAdapter<Body, Call<ApiResponse<Body, Error>>> {

    override fun responseType(): Type = successType

    override fun adapt(call: Call<Body>): Call<ApiResponse<Body, Error>> {
        return ApiResponseCall(call, errorBodyConverter)
    }
}