package com.li.pokemonmvvm.di

import com.li.pokemonmvvm.ui.favorite.FavoriteViewModel
import com.li.pokemonmvvm.ui.home.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get(), androidContext()) }
    viewModel { FavoriteViewModel(get()) }
}
