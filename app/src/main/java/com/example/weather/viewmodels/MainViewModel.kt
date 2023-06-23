package com.example.weather.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.helpers.APPID
import com.example.weather.helpers.LAT
import com.example.weather.helpers.LON
import com.example.weather.model.DetailsModel
import com.example.weather.model.ForecastListModel
import com.example.weather.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {

    private var weatherApi = RetrofitInstance.service


    private val mutableDetailsLiveData = MutableLiveData<DetailsModel>()
    val detailsLiveData: LiveData<DetailsModel> = mutableDetailsLiveData

    private val mutableForecastLiveData = MutableLiveData<ForecastListModel>()
    val forecastLiveData: LiveData<ForecastListModel> = mutableForecastLiveData

    fun getDetails(){
        viewModelScope.launch {
            val details = withContext(Dispatchers.IO) {
                weatherApi.getDetailsWeather(LAT, LON, APPID)
            }
            mutableDetailsLiveData.value = details
        }
    }

    fun getForecast(){
        viewModelScope.launch {
            val forecast = withContext(Dispatchers.IO) {
                weatherApi.getForecast(LAT, LON, APPID)
            }
            mutableForecastLiveData.value = forecast
        }
    }
}