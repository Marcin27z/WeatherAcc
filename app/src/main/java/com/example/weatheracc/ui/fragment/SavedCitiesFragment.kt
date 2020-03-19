package com.example.weatheracc.ui.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController

import com.example.weatheracc.R
import com.example.weatheracc.adapters.CitiesAdapter
import com.example.weatheracc.models.CityWeatherModel
import com.example.weatheracc.viewmodels.SavedCitiesViewModel
import kotlinx.android.synthetic.main.saved_cities_fragment.*

class SavedCitiesFragment : Fragment() {

    companion object {
        fun newInstance() =
            SavedCitiesFragment()
    }

    private val citiesList = mutableListOf(
        CityWeatherModel(
            "1",
            "Warszawa",
            status = "Clear Sky",
            temperature = 15
        ),
        CityWeatherModel(
            "2",
            "Wrocław",
            status = "Clouds",
            temperature = 12
        ),
        CityWeatherModel(
            "3",
            "Poznań",
            status = "Clear Sky",
            temperature = 10
        ),
        CityWeatherModel(
            "4",
            "Gdańsk",
            status = "Clouds",
            temperature = 20
        ),
        CityWeatherModel(
            "5",
            "Los Angeles",
            status = "Sunny",
            temperature = 22
        ),
        CityWeatherModel(
            "6",
            "Miami",
            status = "Sunny",
            temperature = 30
        )
    )

    private lateinit var viewModel: SavedCitiesViewModel

    private val citiesAdapter by lazy {
        CitiesAdapter {
            Toast.makeText(context, it.name, Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.saved_cities_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        citiesRecyclerView.adapter = citiesAdapter.apply {
            submitList(citiesList)
        }
        addLocationButton.setOnClickListener {
            findNavController().navigate(SavedCitiesFragmentDirections.actionSavedCitiesFragmentToSearchCityFragment())
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SavedCitiesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
