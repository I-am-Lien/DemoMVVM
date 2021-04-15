package com.li.pokemonmvvm.data.repository

import com.li.pokemonmvvm.data.model.Pokemon
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface PokemonRepository {
    fun getPokemons(): Observable<List<Pokemon>>
    fun getFavoritePokemons(): Observable<List<Pokemon>>
    fun insertPokemon(pokemon: Pokemon): Completable
    fun deletePokemon(pokemon: Pokemon): Completable
    fun isFavoritePokemon(name: String): Single<Boolean>
}
