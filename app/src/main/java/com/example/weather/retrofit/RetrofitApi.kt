package com.example.weather.retrofit

import com.example.weather.model.CurrentWeatherModel
import com.example.weather.model.DetailsModel
import com.example.weather.model.ForecastListModel
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApi{
    @GET("weather/?&units=metric&lang=en")
    suspend fun getCurrentWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String
    ): CurrentWeatherModel

    @GET("weather/?&units=metric&lang=en")
    suspend fun getDetailsWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String
    ): DetailsModel

    @GET("forecast/?&units=metric&lang=en")
    suspend fun getForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String
    ): ForecastListModel
}