package com.example.androidmasterproject.utils.extension

import android.util.Log

fun Any.print(tag:String) {
    Log.d("***","${tag.uppercase()} : $this")
}