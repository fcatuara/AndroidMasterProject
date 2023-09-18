package com.example.androidmasterproject.ui.fragment

import android.content.Context
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
import com.example.androidmasterproject.utils.extension.makeLinks
import com.example.androidmasterproject.utils.extension.print
import com.example.androidmasterproject.viewmodel.MovieViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding
    private val movieViewModel: MovieViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        print("MovieFragment - onCreateView")
        binding = FragmentMovieBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        print("MovieFragment - onViewCreated")

        movieViewModel.let {
            view.context.apply {
                observeTopRated()
                observePopular()
                observeUpcoming()
            }
            it.getTopRated()
            it.getPopular()
            it.getUpcoming()
        }


        binding.topRated.makeLinks(
            Pair("Invia di nuovo", View.OnClickListener {
                Toast.makeText(view.context, "callllll", Toast.LENGTH_SHORT).show()
            }),
        )

    }


    private fun Context.observeTopRated() {

        movieViewModel.moviesTopRatedLiveData.observe(viewLifecycleOwner, {
            print("MovieFragment - observe top rated ")
            binding.let { view ->
                it.doIfSuccess { data ->
                    view.topRatedRecyclerView.adapter = MovieAdapter(
                        movieList = ArrayList(data?.results.orEmpty()),
                        context = this
                    )
                }
                it.doIfFailure { error, throwable ->
                    Toast.makeText(this, error, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun Context.observePopular() {

        movieViewModel.moviesPopularLiveData.observe(viewLifecycleOwner, {
            print("MovieFragment - observe popular ")
            binding.let { view ->
                it.doIfSuccess { data ->
                    view.popularRecyclerView.adapter = MovieAdapter(
                        movieList = ArrayList(data?.results.orEmpty()),
                        context = this
                    )
                }
                it.doIfFailure { error, throwable ->
                    Toast.makeText(this, error, Toast.LENGTH_LONG).show()
                }
            }
        })

    }

    private fun Context.observeUpcoming() {

        movieViewModel.moviesUpcomingLiveData.observe(viewLifecycleOwner, {
            print("MovieFragment - observe upcoming ")
            binding.let { view ->
                it.doIfSuccess { data ->
                    view.upcomingRecyclerView.adapter = MovieAdapter(
                        movieList = ArrayList(data?.results.orEmpty()),
                        context = this
                    )
                }
                it.doIfFailure { error, throwable ->
                    Toast.makeText(this, error, Toast.LENGTH_LONG).show()
                }
            }
        })

    }
}