package com.example.weather.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather.adapter.ForecastAdapter
import com.example.weather.databinding.FragmentForecastBinding
import com.example.weather.viewmodels.MainViewModel


class ForecastFragment : Fragment() {

    private lateinit var binding: FragmentForecastBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForecastBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        viewModel.forecastLiveData.observe(activity as LifecycleOwner) {
            recyclerView.adapter = ForecastAdapter(it)
        }
    }

}