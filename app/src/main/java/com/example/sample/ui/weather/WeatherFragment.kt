package com.example.sample.ui.weather

import android.os.Bundle
import android.view.View
import com.example.sample.R
import com.example.sample.base.BaseFragment
import com.example.sample.databinding.FragmentWeatherBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment(): BaseFragment<FragmentWeatherBinding, WeatherViewModel>(R.layout.fragment_weather) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setupObserver() {}
}
