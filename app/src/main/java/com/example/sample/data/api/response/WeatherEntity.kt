package com.example.sample.data.api.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherEntity(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val rain: Rain = Rain(),
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind,
)

@Serializable
data class Clouds(
    val all: Int,
)

@Serializable
data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String,
)

@Serializable
data class Main(
    val feels_like: Double,
    val grnd_level: Int,
    val humidity: Int,
    val pressure: Int,
    val sea_level: Int,
    val temp: Double,
    val temp_max: Double,
    val temp_min: Double,
)

@Serializable
data class Coord(
    val lat: Double,
    val lon: Double,
)

@Serializable
data class Sys(
    val country: String,
    val id: Int,
    val sunrise: Int,
    val sunset: Int,
    val type: Int,
)

@Serializable
data class Rain(
    @SerialName("1h")
    val precipitation: Double= 0.0,
)

@Serializable
data class Wind(
    val deg: Int,
    val gust: Double,
    val speed: Double,
)