package com.example.androidmasterproject

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {

   /* override fun onCreate() {
        super.onCreate()
        Log.i(TAG,"onCreate()")
    }*/

    companion object{
        val TAG = MainApplication::javaClass.name
    }
}