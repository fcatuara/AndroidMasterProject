package com.example.androidmasterproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterproject.databinding.MainActivityBinding
import com.example.androidmasterproject.utils.extension.addFragment
import com.example.androidmasterproject.view.PokemonFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        goToPokemonFragment()
    }

    private fun goToPokemonFragment() {
        supportFragmentManager.addFragment(
            fragment = PokemonFragment(),
            isReplace = false,
            isAddToBackStack = true,
            root = R.id.container
        )
    }
}