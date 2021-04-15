package com.li.pokemonmvvm.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.li.pokemonmvvm.R
import com.li.pokemonmvvm.data.model.Pokemon

class FavoriteAdapter : ListAdapter<Pokemon, FavoriteViewHolder>(Pokemon.diffUtil),
    UpdateDataAdapter<Pokemon> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_favorite, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun setData(data: List<Pokemon>?) {
        submitList(data)
    }
}
