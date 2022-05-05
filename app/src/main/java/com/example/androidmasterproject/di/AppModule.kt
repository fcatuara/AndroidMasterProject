package com.example.androidmasterproject.di

import com.example.androidmasterproject.BuildConfig
import com.example.androidmasterproject.MainApplication
import com.example.androidmasterproject.data.service.api.ApiService
import com.example.androidmasterproject.utils.AssetUtils
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


private const val CONNECTION_TIMEOUT = 30L
private const val WRITE_TIMEOUT: Long = 30L
private const val READ_TIMEOUT: Long = 30L

val appModule = module {
    single { MainApplication() }
    single { provideApiService(get()) }
    single { provideRetrofit() }
}

val utilityModule = module {
    single {
        AssetUtils(androidContext())
    }
}

private fun provideApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)


private fun provideRetrofit() =
    Retrofit.Builder()
        .client(provideOkHttpClient())
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)


private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(requestInterceptor)
        .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        .build()

} else OkHttpClient
    .Builder()
    .build()


private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

private val requestInterceptor = Interceptor { chain ->
    val url = chain.request()
        .url
        .newBuilder()
        .build()

    val request = chain.request()
        .newBuilder()
        .url(url)
        .build()

    return@Interceptor chain.proceed(request)
}
