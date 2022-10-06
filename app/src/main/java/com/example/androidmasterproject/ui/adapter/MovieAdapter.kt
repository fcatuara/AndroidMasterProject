package com.example.androidmasterproject.ui.adapter

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidmasterproject.R
import com.example.androidmasterproject.data.model.Result
import com.example.androidmasterproject.databinding.ItemMovieBinding


class MovieAdapter(
    private val movieList: ArrayList<Result>?,
    val context: Context,
) :
    RecyclerView.Adapter<MovieAdapter.PokemonViewHolder>() {

    inner class PokemonViewHolder(private val itemBinding: ItemMovieBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindView(movie: Result) {
            itemBinding.apply {
                movie.poster_path?.let {
                    val posterPath = "https://image.tmdb.org/t/p/w500$it"
                    Glide.with(context)
                        .load(posterPath)
                        //.override(100, 200)
                        .centerInside()
                        .into(this.movieImage);

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        movieList?.get(position)?.let { holder.bindView(it) }
    }

    override fun getItemCount(): Int = movieList?.size ?: 0
}