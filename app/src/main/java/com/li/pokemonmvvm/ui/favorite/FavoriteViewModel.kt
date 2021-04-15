package com.li.pokemonmvvm.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.li.pokemonmvvm.data.model.Pokemon
import com.li.pokemonmvvm.data.repository.PokemonRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class FavoriteViewModel(
    private val repository: PokemonRepository
) : ViewModel() {
    private val disposables = CompositeDisposable()

    private val _pokemons = MutableLiveData<List<Pokemon>>()
    val pokemons: LiveData<List<Pokemon>> get() = _pokemons

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    init {
        getData()
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }

    private fun getData() {
        repository.getFavoritePokemons()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _pokemons.value = it
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposables)
    }
}
