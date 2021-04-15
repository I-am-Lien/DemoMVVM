package com.li.pokemonmvvm.data.model

import com.google.gson.annotations.SerializedName
import com.li.pokemonmvvm.data.model.Pokemon

class PokemonResponse(
    @SerializedName("results")
    val results: List<Pokemon>
)
