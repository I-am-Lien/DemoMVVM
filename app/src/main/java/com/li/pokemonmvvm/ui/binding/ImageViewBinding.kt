package com.li.pokemonmvvm.ui.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.li.pokemonmvvm.utils.Constant
import com.li.pokemonmvvm.utils.loadImage

@BindingAdapter("app:source")
fun loadUrlImage(imageView: ImageView, urlImage: String) {
    val index = urlImage.split("/".toRegex()).toTypedArray()
    val imageName = index[index.size - 1] + ".png"
    val imageUrl = Constant.BASE_IMAGE_URL + imageName
    imageView.loadImage(imageUrl)
}
