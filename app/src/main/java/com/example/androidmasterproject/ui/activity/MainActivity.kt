package com.example.androidmasterproject.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterproject.MainApplication
import com.example.androidmasterproject.R
import com.example.androidmasterproject.databinding.MainActivityBinding
import com.example.androidmasterproject.ui.fragment.PokemonFragment
import com.example.androidmasterproject.utils.extension.addFragment
import com.example.androidmasterproject.utils.extension.print
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var someRandomString: String
    @Inject
    lateinit var application:MainApplication

    lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        someRandomString.print("test some random string")
        goToPokemonFragment()
    }

    private fun goToPokemonFragment() {
        supportFragmentManager.addFragment(
            fragment = PokemonFragment(),
            isReplace = true,
            isAddToBackStack = true,
            root = R.id.container
        )
    }
}