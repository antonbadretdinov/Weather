package com.example.weather

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.weather.databinding.ActivityMainBinding
import com.example.weather.helpers.hasInternetConnection
import com.example.weather.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(hasInternetConnection()){
            viewModel.getDetails()
            viewModel.getForecast()
        }else{
            Toast.makeText(this, "No internet connection", Toast.LENGTH_SHORT).show()
        }


        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        navHostFragment.navController.setGraph(R.navigation.nav_graph, intent.extras)
    }

}