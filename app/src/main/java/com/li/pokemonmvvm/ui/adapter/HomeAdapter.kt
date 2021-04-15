package com.li.pokemonmvvm.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.databinding.DataBindingUtil
import com.li.pokemonmvvm.R
import com.li.pokemonmvvm.data.model.Pokemon

class HomeAdapter(
    private val onItemClick: (Pokemon) -> Unit
) : ListAdapter<Pokemon, HomeViewHolder>(Pokemon.diffUtil), UpdateDataAdapter<Pokemon> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_pokemon, parent, false
            ),
            onItemClick
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun setData(data: List<Pokemon>?) {
        submitList(data)
    }
}
