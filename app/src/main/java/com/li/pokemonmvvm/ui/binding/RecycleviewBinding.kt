package com.li.pokemonmvvm.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.li.pokemonmvvm.ui.adapter.UpdateDataAdapter

@BindingAdapter("app:items")
fun <T> setDataRecyclerView(recyclerView: RecyclerView, data: List<T>?) {
    (recyclerView.adapter as UpdateDataAdapter<T>).setData(data)
}
