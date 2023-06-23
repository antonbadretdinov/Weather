package com.example.weather.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.model.ForecastListModel

class ForecastAdapter(private val forecastList: ForecastListModel):
    RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    private val timeStr = "Time: "
    private val dateStr = "Date: "

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val temp: TextView = view.findViewById(R.id.item_temp)
        val time: TextView = view.findViewById(R.id.item_time)
        val date: TextView = view.findViewById(R.id.item_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.forecast_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = forecastList.list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.time.text = timeStr.plus(forecastList.list[position].dt_txt
            .substringAfterLast(" ")
            .substringBeforeLast(":"))

        holder.date.text = dateStr.plus(forecastList.list[position].dt_txt
            .substringAfter("-").
            substringBeforeLast(" "))

        holder.temp.text = forecastList.list[position].main.temp.toInt().toString()
            .plus("°C")
    }
}