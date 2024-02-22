package com.example.sample.model

import androidx.recyclerview.widget.DiffUtil
import com.example.sample.data.api.response.WordEntity

data class UiWord(
    val id: Int,
    val value: String,
) {

    interface OnItemClickListener {
        fun onItemClick(item: UiWord)
    }

    companion object : DiffUtil.ItemCallback<UiWord>() {
        override fun areItemsTheSame(oldItem: UiWord, newItem: UiWord): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UiWord, newItem: UiWord): Boolean {
            return oldItem == newItem
        }
    }

}

fun WordEntity.toUiModel() = UiWord(this.id, this.value)