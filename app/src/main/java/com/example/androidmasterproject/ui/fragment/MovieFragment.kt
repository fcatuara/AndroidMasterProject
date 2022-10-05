package com.example.androidmasterproject.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.androidmasterproject.databinding.FragmentMovieBinding
import com.example.androidmasterproject.ui.adapter.MovieAdapter
import com.example.androidmasterproject.utils.extension.doIfFailure
import com.example.androidmasterproject.utils.extension.doIfSuccess
import com.example.androidmasterproject.utils.extension.print
import com.example.androidmasterproject.viewmodel.MovieViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding
    private val pokemonViewModel: MovieViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokemonViewModel.moviesLiveData.observe(viewLifecycleOwner, {
            binding.apply {
                it.doIfSuccess { data ->
                    pokemonRecyclerView.adapter = MovieAdapter(
                        movieList = ArrayList(data?.results.orEmpty()),
                        context = view.context
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