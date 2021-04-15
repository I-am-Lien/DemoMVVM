package com.li.pokemonmvvm.data.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.li.pokemonmvvm.data.model.Pokemon
import com.li.pokemonmvvm.data.source.local.db.AppDatabase.Companion.DATABASE_VERSION
import com.li.pokemonmvvm.data.source.local.db.AppDatabase.Companion.EXPORT_SCHEME
import com.li.pokemonmvvm.data.source.local.db.dao.PokemonDao

@Database(
    entities = [Pokemon::class],
    version = DATABASE_VERSION,
    exportSchema = EXPORT_SCHEME
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao

    companion object {
        const val DATABASE_VERSION = 2
        const val DATABASE_NAME = "pokemon_database"
        const val EXPORT_SCHEME = false
    }
}
