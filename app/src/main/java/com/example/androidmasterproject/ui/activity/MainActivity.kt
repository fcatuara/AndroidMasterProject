package com.example.androidmasterproject.ui.activity

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.androidmasterproject.MainApplication
import com.example.androidmasterproject.R
import com.example.androidmasterproject.databinding.MainActivityBinding
import com.example.androidmasterproject.ui.fragment.PokemonFragment
import com.example.androidmasterproject.utils.extension.addFragment
import com.example.androidmasterproject.utils.extension.print


class MainActivity : AppCompatActivity() {

    lateinit var application: MainApplication
    lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateToPokemonFragment()
    }

    private fun navigateToPokemonFragment() {
        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(R.id.action_pokemon_fragment)
    }

}