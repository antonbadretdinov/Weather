package com.example.weather.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.weather.R
import com.example.weather.databinding.FragmentDetailsBinding
import com.example.weather.viewmodels.MainViewModel

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tempMetric = resources.getString(R.string.temp_metric)
        val pressureMetric = resources.getString(R.string.pressure_metric)
        val humidityMetric = resources.getString(R.string.humidity_metric)
        val windSpeedMetric = resources.getString(R.string.wind_speed_metric)
        viewModel.detailsLiveData.observe(activity as LifecycleOwner){
            with(binding) {
                tvTemp.text = resources.getString(R.string.temp)
                    .plus(it.main.temp)
                    .plus(tempMetric)

                tvFeelsLike.text = resources.getString(R.string.feels_like)
                    .plus(it.main.feels_like)
                    .plus(tempMetric)

                tvTempMin.text = resources.getString(R.string.temp_min)
                    .plus(it.main.temp_min)
                    .plus(tempMetric)

                tvTempMax.text = resources.getString(R.string.temp_max)
                    .plus(it.main.temp_max)
                    .plus(tempMetric)

                tvPressure.text = resources.getString(R.string.pressure)
                    .plus(it.main.pressure)
                    .plus(pressureMetric)

                tvHumidity.text = resources.getString(R.string.humidity)
                    .plus(it.main.humidity)
                    .plus(humidityMetric)

                tvWind.text = resources.getString(R.string.wind_spd)
                    .plus(it.wind.speed)
                    .plus(windSpeedMetric)

                tvDescription.text = resources.getString(R.string.description)
                    .plus(it.weather[0].description)
            }
        }
    }
}