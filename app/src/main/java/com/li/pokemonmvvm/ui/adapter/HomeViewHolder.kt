package com.li.pokemonmvvm.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.li.pokemonmvvm.data.model.Pokemon
import com.li.pokemonmvvm.databinding.ItemPokemonBinding

class HomeViewHolder(
    private val binding: ItemPokemonBinding,
    onClickItem: (Pokemon) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private var itemPokemon: Pokemon? = null

    init {
        binding.imageFavorite.setOnClickListener {
            itemPokemon?.let {
                onClickItem(it)
            }
        }
    }

    fun bind(pokemon: Pokemon) {
        itemPokemon = pokemon
        binding.setVariable(POKEMON_BINDING_ID, pokemon)
        binding.executePendingBindings()
    }

    companion object {
        const val POKEMON_BINDING_ID = 1
    }
}
