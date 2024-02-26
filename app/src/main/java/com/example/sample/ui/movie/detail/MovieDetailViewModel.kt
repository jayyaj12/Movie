package com.example.sample.ui.movie.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.example.sample.base.BaseViewModel
import com.example.sample.model.UiMoviePopular

class MovieDetailViewModel(stateHandle: SavedStateHandle): BaseViewModel() {

    var movieItem: LiveData<UiMoviePopular> = stateHandle.getLiveData("movie")
}