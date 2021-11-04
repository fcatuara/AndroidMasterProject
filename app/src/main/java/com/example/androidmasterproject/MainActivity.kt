package com.example.androidmasterproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterproject.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}