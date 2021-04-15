package com.li.pokemonmvvm.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.li.pokemonmvvm.ui.adapter.FavoriteAdapter
import com.li.pokemonmvvm.ui.adapter.FavoriteViewHolder
import com.li.pokemonmvvm.utils.showToast
import com.li.pokemonmvvm.R
import com.li.pokemonmvvm.databinding.FragmentFavoriteBinding
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {

    private val adapter = FavoriteAdapter()
    private val favoriteViewModel by viewModel<FavoriteViewModel>()
    private var binding: FragmentFavoriteBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil
        .inflate<FragmentFavoriteBinding>(inflater, R.layout.fragment_favorite, container, false)
        .apply { binding = this }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycleFavoritePokemon.adapter = adapter
        initData()
        observeData()
    }

    private fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            setVariable(FavoriteViewHolder.POKEMON_BINDING_ID, favoriteViewModel)
        }
    }

    private fun observeData() = with(favoriteViewModel) {
        error.observe(viewLifecycleOwner, Observer {
            context?.showToast(it)
        })
    }
}
