package com.example.sample.data.api

import android.graphics.Region
import com.example.mvvmexample.util.network.NetworkState
import com.example.sample.data.api.response.MoviePopularEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    // 인기 영화 검색
    @GET("movie/popular")
    suspend fun getMoviePopular(
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("region") region: String? = null
    ): NetworkState<MoviePopularEntity>

}