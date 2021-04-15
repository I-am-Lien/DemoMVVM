package com.li.pokemonmvvm.data.repository

import com.li.pokemonmvvm.data.model.Pokemon
import com.li.pokemonmvvm.data.source.PokemonDataSource
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class PokemonRepositoryImpl(
    private val local: PokemonDataSource.Local,
    private val remote: PokemonDataSource.Remote
) : PokemonRepository {

    override fun getPokemons(): Observable<List<Pokemon>> = remote.getPokemons().map { it.results }
    override fun getFavoritePokemons(): Observable<List<Pokemon>> = local.getFavoritePokemons()
    override fun insertPokemon(pokemon: Pokemon): Completable = local.addPokemon(pokemon)
    override fun deletePokemon(pokemon: Pokemon): Completable = local.deletePokemon(pokemon)
    override fun isFavoritePokemon(name: String): Single<Boolean> = local.isFavorite(name)
}
