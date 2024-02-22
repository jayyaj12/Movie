package com.example.sample.ui.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.sample.base.BaseViewModel
import com.example.sample.data.repository.WordRepository
import com.example.sample.model.UiWord
import com.example.sample.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(
    private val wordRepository: WordRepository,
) : BaseViewModel() {
    private val _wordItems = MutableLiveData<MutableList<UiWord>>(mutableListOf())
    val wordItems: LiveData<MutableList<UiWord>> get() = _wordItems

    private val _lastRequestedPage = MutableLiveData(0)
    val lastRequestedPage: LiveData<Int> get() = _lastRequestedPage

    private var isLoading: Boolean = false

    init {
        getWords()
    }

    fun getWords() {
        if (isLoading) return

        val page = lastRequestedPage.value ?: 0
        viewModelScope.launch {
            isLoading = true
            val items = wordRepository.getWords(page).map { it.toUiModel() }
            _wordItems.value = if (page == 0) {
                items.toMutableList()
            } else {
                wordItems.value?.apply { addAll(items) }
            }
            _lastRequestedPage.value = page + 1
            isLoading = false
        }
    }
}