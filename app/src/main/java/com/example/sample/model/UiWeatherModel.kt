package com.example.sample.model

import com.example.sample.data.api.response.Coord
import com.example.sample.data.api.response.Main
import com.example.sample.data.api.response.Weather
import com.example.sample.data.api.response.WeatherEntity
import kotlin.math.roundToInt

data class UiWeatherModel(
    val temp: String = "0.0",
    val tempMin: String = "0.0",
    val tempMax: String = "0.0",
    val humidity: String = "0",
    val windSpeed: String = "0.0",
    val precipitation: String = "0.0"
)

fun WeatherEntity.toUiWeatherModel(): UiWeatherModel {
    return UiWeatherModel(
        temp = "현재 온도: ${this.main.temp}°C",
        tempMin = "최소 온도: ${this.main.temp_min}°C",
        tempMax = "최대 온도: ${this.main.temp_max}°C",
        humidity = "습도: ${this.main.humidity}%",
        windSpeed = "풍속: ${this.wind.speed.roundToInt()}m/s",
        precipitation = "시간당 강수량 ${this.rain.precipitation}mm"
    )
}