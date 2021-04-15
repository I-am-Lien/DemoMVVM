package com.li.pokemonmvvm.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.li.pokemonmvvm.data.model.Pokemon
import com.li.pokemonmvvm.databinding.ItemFavoriteBinding

class FavoriteViewHolder(
    private val binding: ItemFavoriteBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(pokemon: Pokemon) {
        binding.setVariable(POKEMON_BINDING_ID, pokemon)
        binding.executePendingBindings()
    }

    companion object {
        const val POKEMON_BINDING_ID = 2
    }
}
