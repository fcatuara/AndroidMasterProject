package com.example.androidmasterproject.utils

import android.content.Context
import java.io.InputStream
import java.nio.charset.Charset

class AssetUtils (private val context:Context) {

    fun getJsonFromAsset(fileName: String): String? {
        return try {
            val inputStream: InputStream = context.assets.open(fileName)
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)

            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charset.forName("UTF-8"))

        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }
}