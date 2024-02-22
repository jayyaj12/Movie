package com.example.sample.data.api

import com.example.sample.data.api.response.WordEntity
import kotlinx.coroutines.delay
import kotlin.random.Random

class WordApiService {

    private val sampleWords = listOf<String>(
        "Kotlin",
        "Android",
        "Android Studio",
        "Hello",
        "Github",
        "Linkedin",
        "Instagram",
        "Mega",
        "Coffee",
        "Sample",
    )

    suspend fun getWords(page: Int): List<WordEntity> {
        delay(500L)
        val words = mutableListOf<WordEntity>()
        val start = page * 20
        for (index: Int in start until start + 20) {
            words.add(WordEntity(index, sampleWords[Random.nextInt(sampleWords.size)]))
        }

        return words
    }

}