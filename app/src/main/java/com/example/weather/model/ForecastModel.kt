package com.example.weather.model

data class ForecastListModel(
    val list: List<ForecastModel>
)

data class ForecastModel(
    val main: DataForecast,
    val dt_txt: String
)

data class DataForecast(
    val temp: Double
)