package com.example.androidmasterproject.network

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import javax.inject.Inject

class ApiResponseAdapterFactory @Inject constructor() : CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {

        /**
         * Suspend functions wrap the response type in `Call`
         */
        if (getRawType(returnType) != Call::class.java) return null

        /**
         * Check first that the return type is `ParameterizedType`
         */
        check(returnType is ParameterizedType) { "return type must be parameterized as Call<ApiResponse<<Foo>> or Call<ApiResponse<out Foo>>" }

        /**
         * Get the response type inside the `Call` type
         */
        val responseType = getParameterUpperBound(0, returnType)

        /**
         * If the response type is not ApiResponse then we can't handle this type, so we return null
         */
        if (getRawType(responseType) != ApiResponse::class.java) return null

        /**
         * The response type is ApiResponse and should be parameterized
         */
        check(responseType is ParameterizedType) { "Response must be parameterized as ApiResponse<Foo> or ApiResponse<out Foo>" }

        val successBodyType = getParameterUpperBound(0, responseType)
        val errorBodyType = getParameterUpperBound(1, responseType)

        val errorBodyConverter = retrofit.nextResponseBodyConverter<Any>(null, errorBodyType, annotations)

        return ApiResponseAdapter<Any, Any>(successBodyType, errorBodyConverter)

    }
}