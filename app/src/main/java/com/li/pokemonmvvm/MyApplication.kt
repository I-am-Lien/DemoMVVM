package com.li.pokemonmvvm

import android.app.Application
import com.li.pokemonmvvm.di.*
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                listOf(
                    netWorkModule,
                    apiModule,
                    repoPokemonModule,
                    viewModelModule,
                    dbModule
                )
            )
        }
    }
}
