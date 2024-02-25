package com.example.sample.data.api.response

import kotlinx.serialization.Serializable

@Serializable
data class MoviePopularEntity(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)