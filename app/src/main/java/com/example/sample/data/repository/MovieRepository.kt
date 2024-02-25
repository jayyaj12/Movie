package com.example.sample.data.repository

import com.example.sample.model.UiMoviePopular

interface MovieRepository {

    suspend fun getMoviePopular(language: String, page: Int, region: String? = null): Result<List<UiMoviePopular>>

}