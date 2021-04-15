package com.li.pokemonmvvm.data.source.remote.utils

import io.reactivex.rxjava3.core.Observable
import com.li.pokemonmvvm.data.model.PokemonResponse
import retrofit2.http.GET

interface APIServices {
    @GET("pokemon")
    fun getPokemons(): Observable<PokemonResponse>
}
