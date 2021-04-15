package com.li.pokemonmvvm.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.li.pokemonmvvm.R

fun ImageView.loadImage(image: String?) {
    Glide.with(context).load(image)
        .error(R.drawable.ic_error)
        .placeholder(R.drawable.ic_place_holder)
        .into(this)
}
