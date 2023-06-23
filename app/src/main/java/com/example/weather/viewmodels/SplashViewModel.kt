package com.example.weather.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.helpers.APPID
import com.example.weather.helpers.LAT
import com.example.weather.helpers.LON
import com.example.weather.model.CurrentWeatherModel
import com.example.weather.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashViewModel: ViewModel() {

    private val mutableWeatherLiveData = MutableLiveData<CurrentWeatherModel>()
    val weatherLiveData: LiveData<CurrentWeatherModel> = mutableWeatherLiveData

    private var weatherApi = RetrofitInstance.service

    fun getCurrentWeather() {
        viewModelScope.launch {
            val currentWeather = withContext(Dispatchers.IO) {
                weatherApi.getCurrentWeather(LAT, LON, APPID)
            }
            mutableWeatherLiveData.value = currentWeather
        }
    }
}