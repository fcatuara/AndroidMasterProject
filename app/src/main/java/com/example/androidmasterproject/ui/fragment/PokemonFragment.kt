package com.example.androidmasterproject.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.androidmasterproject.databinding.FragmentPokemonBinding
import com.example.androidmasterproject.utils.extension.doIfFailure
import com.example.androidmasterproject.utils.extension.doIfSuccess
import com.example.androidmasterproject.viewmodel.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonFragment : Fragment() {

    private lateinit var binding: FragmentPokemonBinding
    private val pokemonViewModel: PokemonViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokemonBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokemonViewModel.pokemonLiveData.observe(viewLifecycleOwner, {
            it.doIfSuccess { data ->
                //TODO set data inside Adapter
            }
            it.doIfFailure { error, throwable ->
                //TODO show error message as you prefer (Toast, dialog, etc..)
            }
        })

        pokemonViewModel.getPokemon(234L)
    }
}