package com.example.tp6_adnene.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp6_adnene.R

class CityAdapter(private val cityList: Array<String>, private val cityListener: onCityclickListener) : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {


    class CityViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.city_name)


        fun bind(city: String, listener: onCityclickListener) {
            textView.text = city
            itemView.setOnClickListener {
                listener.onCityclick(city)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.city_item, parent, false)
        return CityViewHolder(adapterLayout)
    }


    override fun getItemCount(): Int {
        return cityList.size
    }


    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(cityList[position], cityListener)
    }


    interface onCityclickListener {
        fun onCityclick(city: String)
    }
}
