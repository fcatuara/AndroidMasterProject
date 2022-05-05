package com.example.androidmasterproject.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.androidmasterproject.databinding.FragmentPokemonBinding
import com.example.androidmasterproject.ui.adapter.PokemonsAdapter
import com.example.androidmasterproject.utils.extension.doIfFailure
import com.example.androidmasterproject.utils.extension.doIfSuccess
import com.example.androidmasterproject.utils.extension.print
import com.example.androidmasterproject.viewmodel.PokemonViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class PokemonFragment : Fragment() {

    private lateinit var binding: FragmentPokemonBinding
    private val pokemonViewModel: PokemonViewModel by viewModel()

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
            binding.apply {
                it.doIfSuccess { data ->
                    pokemonRecyclerView.adapter = PokemonsAdapter(
                        ArrayList(data?.results.orEmpty())
                    )
                }
                it.doIfFailure { error, throwable ->
                    Toast.makeText(view.context, error, Toast.LENGTH_LONG).show()
                    throwable?.print("doIfFailure")
                }
            }
        })

        pokemonViewModel.getPokemon()
    }
}