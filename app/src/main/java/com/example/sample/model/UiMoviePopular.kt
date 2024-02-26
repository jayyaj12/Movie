package com.example.sample.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.example.sample.data.api.response.MoviePopularEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class UiMoviePopular(
    val id: String,
    val posterPath: String,
    val title: String,
    val overview: String
): Parcelable {

    interface OnItemClickListener {
        fun onItemClick(item: UiMoviePopular)
    }

    companion object : DiffUtil.ItemCallback<UiMoviePopular>() {
        override fun areItemsTheSame(oldItem: UiMoviePopular, newItem: UiMoviePopular): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UiMoviePopular, newItem: UiMoviePopular): Boolean {
            return oldItem == newItem
        }
    }
}

fun MoviePopularEntity.toUiMoviePopularModel(): List<UiMoviePopular> {
    return this.results.map {
        UiMoviePopular(
            id = it.id.toString(),
            posterPath = "https://image.tmdb.org/t/p/w500/${it.poster_path}",
            title = it.title,
            overview = it.overview
        )
    }
}
