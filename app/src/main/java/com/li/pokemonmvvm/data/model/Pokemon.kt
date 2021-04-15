package com.li.pokemonmvvm.data.model

import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "pokemon")
data class Pokemon(
    @PrimaryKey
    @SerializedName("name")
    @ColumnInfo(name = "name")
    val name: String,
    @SerializedName("url")
    @ColumnInfo(name = "url")
    var imageUrl: String,
    @SerializedName("favorite")
    var isFavorite: Boolean
) {

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Pokemon>() {
            override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon) =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon) =
                oldItem == newItem
        }
    }
}
