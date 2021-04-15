package com.li.pokemonmvvm.data.source.remote

import com.li.pokemonmvvm.data.model.PokemonResponse
import com.li.pokemonmvvm.data.source.PokemonDataSource
import com.li.pokemonmvvm.data.source.remote.utils.APIServices
import io.reactivex.rxjava3.core.Observable

class PokemonRemoteDataSource(
    private val apiServices: APIServices
) : PokemonDataSource.Remote {

    override fun getPokemons(): Observable<PokemonResponse> = apiServices.getPokemons()
}
