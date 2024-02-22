package com.example.sample.data.repository

import com.example.sample.data.api.response.WordEntity

interface WordRepository {

    suspend fun getWords(page: Int): List<WordEntity>

}