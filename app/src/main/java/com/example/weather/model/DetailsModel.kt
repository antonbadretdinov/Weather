package com.example.weather.model

data class DetailsModel(
    val weather: List<Description>,
    val main: DetailsData,
    val wind: Wind
)

data class DetailsData(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Int,
    val humidity: Int
)

data class Description(
    val description: String
)