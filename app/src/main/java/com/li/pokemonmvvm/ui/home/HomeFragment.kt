package com.li.mvvmdemo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.li.pokemonmvvm.ui.adapter.HomeAdapter
import com.li.pokemonmvvm.ui.adapter.HomeViewHolder
import androidx.lifecycle.Observer
import com.li.pokemonmvvm.data.model.Pokemon
import com.li.pokemonmvvm.utils.showToast
import com.li.pokemonmvvm.R
import com.li.pokemonmvvm.databinding.FragmentHomeBinding
import com.li.pokemonmvvm.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private val adapter = HomeAdapter(::clickFavoriteImage)
    private val homeViewModel by viewModel<HomeViewModel>()
    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil
        .inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home, container, false)
        .apply { binding = this }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclePokemon.adapter = adapter
        initData()
        observeData()
    }

    private fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            setVariable(HomeViewHolder.POKEMON_BINDING_ID, homeViewModel)
        }
    }

    private fun observeData() = with(homeViewModel) {
        error.observe(viewLifecycleOwner, Observer {
            context?.showToast(it)
        })
        message.observe(viewLifecycleOwner, Observer {
            context?.showToast(it)
        })
    }

    private fun clickFavoriteImage(pokemon: Pokemon) {
        homeViewModel.updateFavorite(pokemon)
    }
}
