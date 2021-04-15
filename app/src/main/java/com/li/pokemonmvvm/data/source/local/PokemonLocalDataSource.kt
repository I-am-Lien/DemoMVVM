package com.li.pokemonmvvm.data.source.local

import com.li.pokemonmvvm.data.model.Pokemon
import com.li.pokemonmvvm.data.source.PokemonDataSource
import com.li.pokemonmvvm.data.source.local.db.dao.PokemonDao
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class PokemonLocalDataSource(
    private val pokemonDao: PokemonDao
) : PokemonDataSource.Local {

    override fun getFavoritePokemons(): Observable<List<Pokemon>> = pokemonDao.getFavorites()

    override fun addPokemon(pokemon: Pokemon): Completable = pokemonDao.insertFavorites(pokemon)

    override fun deletePokemon(pokemon: Pokemon): Completable = pokemonDao.deleteFavorites(pokemon)

    override fun isFavorite(name: String): Single<Boolean> =
        pokemonDao.isFavorite(name).map { it.isNotEmpty() }
}
