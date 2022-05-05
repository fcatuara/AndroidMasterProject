package com.example.androidmasterproject

import android.app.Application
import com.example.androidmasterproject.di.appModule
import com.example.androidmasterproject.di.repoModule
import com.example.androidmasterproject.di.utilityModule
import com.example.androidmasterproject.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.EmptyLogger
import org.koin.core.logger.Level

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            if (BuildConfig.DEBUG) androidLogger(Level.ERROR) else EmptyLogger()
            androidContext(this@MainApplication)
            modules(
                listOf(
                    appModule,
                    utilityModule,
                    repoModule,
                    viewModelModule
                )
            )
        }
    }
}