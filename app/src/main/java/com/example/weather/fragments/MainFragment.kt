package com.example.weather.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.weather.R
import com.example.weather.databinding.FragmentMainBinding
import com.example.weather.helpers.parcelable
import com.example.weather.model.CurrentWeatherModel

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private var currentWeather: CurrentWeatherModel? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        currentWeather = activity?.intent?.extras?.parcelable("model")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tempMetric = resources.getString(R.string.temp_metric)
        val pressureMetric = resources.getString(R.string.pressure_metric)
        val humidityMetric = resources.getString(R.string.humidity_metric)
        val windSpeedMetric = resources.getString(R.string.wind_speed_metric)
        currentWeather?.let {
            with(binding) {
                tvTemp.text = it.main.temp.toInt().toString()
                    .plus(tempMetric)

                tvWindSpd.text = resources.getString(R.string.wind_spd)
                    .plus(it.wind.speed.toInt().toString())
                    .plus(windSpeedMetric)

                tvPressure.text = resources.getString(R.string.pressure)
                    .plus(it.main.pressure.toString())
                    .plus(pressureMetric)

                tvHumidity.text = resources.getString(R.string.humidity)
                    .plus(it.main.humidity.toString())
                    .plus(humidityMetric)
            }
        }

        binding.btnDetails.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_detailsFragment)
        }
        binding.btnForecast.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_forecastFragment)
        }
    }
}