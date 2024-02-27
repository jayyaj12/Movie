package com.example.sample.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.sample.BuildConfig
import com.example.sample.base.BaseViewModel
import com.example.sample.data.repository.WeatherRepository
import com.example.sample.model.UiWeatherModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherRepository: WeatherRepository): BaseViewModel() {

    init {
        getWeatherData()
    }

    private var _weather = MutableStateFlow<UiWeatherModel>(UiWeatherModel())
    val weather: StateFlow<UiWeatherModel> = _weather

    companion object {
        const val UNITS = "metric"
        const val LANG = "kr"
        const val APP_ID = BuildConfig.OEPN_WEATHER_API_KEY
    }

    fun getWeatherData() {
        viewModelScope.launch {
            weatherRepository.getWeatherData(
                lat = 37.31,
                lon = 126.98,
                appId = APP_ID,
                units = UNITS,
                lang = LANG
            ).onSuccess {
                _weather.emit(it)
            }.onFailure {

            }
        }
    }

}