package com.example.sample.data.api

import com.example.mvvmexample.util.network.NetworkState
import com.example.sample.data.api.response.WeatherEntity
import com.example.sample.di.NetworkModule
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("weather")
    suspend fun getWeatherData(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appId: String? = null,
        @Query("units") units: String? = null,
        @Query("mode") mode: String? = null,
        @Query("lang") lang: String? = null,
    ): NetworkState<WeatherEntity>

}