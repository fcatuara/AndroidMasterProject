package com.example.androidmasterproject.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterproject.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate")
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object{
        val TAG: String = MainActivity::javaClass.name
    }
}