package com.li.pokemonmvvm.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.li.pokemonmvvm.R
import com.li.pokemonmvvm.data.model.Pokemon
import com.li.pokemonmvvm.data.repository.PokemonRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel(
    private val repository: PokemonRepository,
    private val context: Context
) : ViewModel() {
    private val disposables = CompositeDisposable()

    private val _pokemons = MutableLiveData<List<Pokemon>>()
    val pokemons: LiveData<List<Pokemon>> get() = _pokemons

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> get() = _message

    init {
        getData()
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }

    private fun getData() {
        repository.getPokemons()
            .map {
                it.forEach { item ->
                    repository.isFavoritePokemon(item.name)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ isFavorite ->
                            item.isFavorite = isFavorite
                        }, { error ->
                            _error.value = error.message.toString()
                        })
                }
                _pokemons.value = it
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun updateFavorite(pokemon: Pokemon) {
        if (pokemon.isFavorite) {
            repository.deletePokemon(pokemon)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _message.value = context.resources.getString(R.string.delete_success)
                }, {
                    _message.value = context.resources.getString(R.string.delete_fail)
                })
                .addTo(disposables)
        } else {
            repository.insertPokemon(pokemon)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _message.value = context.resources.getString(R.string.add_success)
                }, {
                    _message.value = context.resources.getString(R.string.add_fail)
                })
                .addTo(disposables)
        }
    }
}
