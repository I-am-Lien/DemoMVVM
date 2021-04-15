package com.li.pokemonmvvm.data.source

import com.li.pokemonmvvm.data.model.Pokemon
import com.li.pokemonmvvm.data.model.PokemonResponse
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface PokemonDataSource {
    interface Remote {
        fun getPokemons(): Observable<PokemonResponse>
    }

    interface Local {
        fun getFavoritePokemons(): Observable<List<Pokemon>>
        fun addPokemon(pokemon: Pokemon): Completable
        fun deletePokemon(pokemon: Pokemon): Completable
        fun isFavorite(name: String): Single<Boolean>
    }
}
