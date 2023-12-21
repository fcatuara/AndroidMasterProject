package com.example.androidmasterproject.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class HttpRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        with(chain.request()) {
            return chain.proceed(newBuilder().url(url).build())
        }
    }
}
