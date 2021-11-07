package com.example.androidmasterproject.utils.extension

import com.example.androidmasterproject.utils.ResultOf

inline fun <reified T> ResultOf<T>.doIfFailure(callback: (error: String?, throwable: Throwable?) -> Unit) {
    if (this is ResultOf.Failure) {
        callback(message, throwable)
    }
}

inline fun <reified T> ResultOf<T>.doIfSuccess(callback: (data: T) -> Unit) {
    if (this is ResultOf.Success) {
        callback(data)
    }
}