package com.li.pokemonmvvm.di

import com.li.pokemonmvvm.data.source.remote.utils.APIServices
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(APIServices::class.java) }
}
