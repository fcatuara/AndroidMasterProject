package com.example.androidmasterproject.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.androidmasterproject.MainApplication
import com.example.androidmasterproject.R
import com.example.androidmasterproject.databinding.MainActivityBinding


class MainActivity : AppCompatActivity() {

    lateinit var application: MainApplication
    lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateToMovieView()
    }

    private fun navigateToMovieView() {
        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(R.id.action_pokemon_fragment)
    }

}