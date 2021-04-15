package com.li.pokemonmvvm.data.source.local.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.li.pokemonmvvm.data.model.Pokemon
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemon")
    fun getFavorites(): Observable<List<Pokemon>>

    @Insert
    fun insertFavorites(pokemon: Pokemon): Completable

    @Delete
    fun deleteFavorites(pokemon: Pokemon): Completable

    @Query("SELECT * FROM pokemon WHERE name =:name")
    fun isFavorite(name: String): Single<List<Pokemon>>
}
