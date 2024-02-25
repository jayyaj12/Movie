package com.example.sample.ui.movie.detail

import androidx.lifecycle.MutableLiveData
import com.example.sample.base.BaseViewModel
import com.example.sample.model.UiMoviePopular

class MovieDetailViewModel: BaseViewModel() {

    var movieItem = MutableLiveData<UiMoviePopular>()

    fun setMovieItem(item: UiMoviePopular) {
        movieItem.value = item
    }

}