package com.example.androidmasterproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmasterproject.data.model.Result
import com.example.androidmasterproject.databinding.ItemPokemonBinding

class PokemonsAdapter(private val pokemonList: ArrayList<Result>?) :
    RecyclerView.Adapter<PokemonsAdapter.PokemonViewHolder>() {

    inner class PokemonViewHolder(private val itemBinding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindView(pokemon: Result) {
            itemBinding.apply {
               pokemonName.text = pokemon.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            ItemPokemonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        pokemonList?.get(position)?.let { holder.bindView(it) }
    }

    override fun getItemCount(): Int = pokemonList?.size ?: 0
}