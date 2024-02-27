package com.example.sample.data.repository

import com.example.mvvmexample.util.network.NetworkState
import com.example.mvvmexample.util.network.RetrofitFailureStateException
import com.example.sample.data.api.WeatherApiService
import com.example.sample.data.api.response.WeatherEntity
import com.example.sample.model.UiWeatherModel
import com.example.sample.model.toUiMoviePopularModel
import com.example.sample.model.toUiWeatherModel
import timber.log.Timber
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val weatherApiService: WeatherApiService): WeatherRepository {

    override suspend fun getWeatherData(
        lat: Double,
        lon: Double,
        appId: String,
        units: String?,
        mode: String?,
        lang: String?,
    ): Result<UiWeatherModel> {
        when(val weatherData =
            weatherApiService.getWeatherData(lat = lat, lon = lon, appId = appId, units = units, mode = mode, lang = lang)) {
            is NetworkState.Success -> return Result.success(weatherData.body.toUiWeatherModel())
            is NetworkState.Failure -> return Result.failure(
                RetrofitFailureStateException(weatherData.error, weatherData.code)
            )
            is NetworkState.NetworkError -> Timber.tag("${this.javaClass.name}_getSearchBook").d(weatherData.error)
            is NetworkState.UnknownError -> Timber.tag("${this.javaClass.name}_getSearchBook").d(weatherData.t)
        }
        return Result.failure(IllegalStateException("NetworkError or UnKnownError please check timber"))

    }
}