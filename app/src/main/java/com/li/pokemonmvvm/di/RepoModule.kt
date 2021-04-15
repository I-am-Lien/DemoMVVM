package com.li.pokemonmvvm.di

import androidx.room.Room
import com.li.pokemonmvvm.data.repository.PokemonRepository
import com.li.pokemonmvvm.data.repository.PokemonRepositoryImpl
import com.li.pokemonmvvm.data.source.PokemonDataSource
import com.li.pokemonmvvm.data.source.local.PokemonLocalDataSource
import com.li.pokemonmvvm.data.source.local.db.AppDatabase
import com.li.pokemonmvvm.data.source.remote.PokemonRemoteDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dbModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }
    single { get<AppDatabase>().pokemonDao() }
}
val repoPokemonModule = module {
    single<PokemonDataSource.Remote> { PokemonRemoteDataSource(get()) }
    single<PokemonDataSource.Local> { PokemonLocalDataSource(get()) }
    single<PokemonRepository> { PokemonRepositoryImpl(get(), get()) }
}
