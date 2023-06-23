package com.example.weather.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.net.ConnectivityManager.*
import android.net.NetworkCapabilities.*
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.weather.MainActivity
import com.example.weather.databinding.ActivitySplashBinding
import com.example.weather.helpers.hasInternetConnection
import com.example.weather.viewmodels.SplashViewModel
import kotlinx.coroutines.*


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding
    private val weatherViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        
        if(applicationContext.hasInternetConnection()) {
            weatherViewModel.getCurrentWeather()
        }
        else{
            Toast.makeText(this, "No internet connection", Toast.LENGTH_SHORT).show()
            binding.progressBar.visibility = View.INVISIBLE
            binding.btnTryAgain.visibility = View.VISIBLE
        }


        weatherViewModel.weatherLiveData.observe(this){
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("model",it)
            startActivity(intent)
            finish()
        }
        
        binding.btnTryAgain.setOnClickListener {
            if(applicationContext.hasInternetConnection()) {
                weatherViewModel.getCurrentWeather()
            }
            else{
                Toast.makeText(this, "No internet connection", Toast.LENGTH_SHORT).show()
            }
        }

    }
}