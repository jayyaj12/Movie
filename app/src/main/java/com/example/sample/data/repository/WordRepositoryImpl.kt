package com.example.sample.data.repository

import com.example.sample.data.api.WordApiService
import com.example.sample.data.api.response.WordEntity
import javax.inject.Inject

class WordRepositoryImpl @Inject constructor(
    private val apiService: WordApiService,
) : WordRepository {

    override suspend fun getWords(page: Int): List<WordEntity> {
        return apiService.getWords(page)
    }
}