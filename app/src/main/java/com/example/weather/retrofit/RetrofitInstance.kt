package com.example.weather.retrofit

import com.example.weather.helpers.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: RetrofitApi = builder.create(RetrofitApi::class.java)
}