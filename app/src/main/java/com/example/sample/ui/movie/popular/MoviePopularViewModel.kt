package com.example.sample.ui.movie.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.sample.base.BaseViewModel
import com.example.sample.data.repository.MovieRepository
import com.example.sample.model.UiMoviePopular
import com.example.sample.ui.movie.SearchLanguage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviePopularViewModel @Inject constructor(private val movieRepository: MovieRepository): BaseViewModel() {

    private var getMoviePage = MutableLiveData<Int>(1)

    private var _getMovieList = MutableLiveData<MutableList<UiMoviePopular>>(mutableListOf())
    val getMovieList: LiveData<MutableList<UiMoviePopular>> get() = _getMovieList
    private var isRequestInProgress = false

    init {
        getMoviePopular(languageParam = SearchLanguage.KO)
    }

    // 인기 영화 조회
    fun getMoviePopular(languageParam: SearchLanguage) {
        if(isRequestInProgress) return
        
        val language: String = getLanguage(languageParam)
        viewModelScope.launch {
            isRequestInProgress = true
            val items = movieRepository.getMoviePopular(
                language = language,
                page = getMoviePage.value ?: 1
            )

            items.onSuccess {
                getMoviePage.value = getMoviePage.value!! + 1
                _getMovieList.value = if(getMoviePage.value == 1) {
                    it.toMutableList()
                } else {
                    getMovieList.value?.apply { addAll(it) }
                }
                isRequestInProgress = false
            }.onFailure {
                isRequestInProgress = false

            }
        }
    }

    private fun getLanguage(language: SearchLanguage): String {
        return when(language) {
            SearchLanguage.KO -> "ko"
            SearchLanguage.EN -> "en"
        }
    }

}