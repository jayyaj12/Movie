package com.example.sample.data.repository

import com.example.mvvmexample.util.network.NetworkState
import com.example.sample.data.api.response.WeatherEntity
import com.example.sample.model.UiWeatherModel

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, lon: Double, appId: String, units: String?= null, mode: String? = null, lang: String? = null): Result<UiWeatherModel>
}