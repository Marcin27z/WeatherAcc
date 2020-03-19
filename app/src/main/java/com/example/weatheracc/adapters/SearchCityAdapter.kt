package com.example.weatheracc.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatheracc.R
import com.example.weatheracc.models.CityModel
import kotlinx.android.synthetic.main.item_search_city.view.*

class SearchCityAdapter(private val listener: (CityModel) -> Unit):
    ListAdapter<CityModel, SearchCityAdapter.CitiesNamesViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CitiesNamesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_search_city, parent, false))

    override fun onBindViewHolder(holder: CitiesNamesViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    companion object {
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<CityModel>() {
            override fun areItemsTheSame(oldItem: CityModel, newItem: CityModel) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: CityModel, newItem: CityModel) =
                oldItem == newItem
        }
    }

    class CitiesNamesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(city: CityModel, listener: (CityModel) -> Unit) {
            itemView.apply {
                cityTextView.text = "${city.name}, ${city.country}"
            }
        }
    }


}