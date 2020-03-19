package com.example.weatheracc.ui.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.weatheracc.R
import com.example.weatheracc.adapters.CitiesAdapter
import com.example.weatheracc.adapters.SearchCityAdapter
import com.example.weatheracc.models.CityModel
import com.example.weatheracc.viewmodels.SearchCityViewModel
import kotlinx.android.synthetic.main.search_city_fragment.*


class SearchCityFragment : Fragment() {

    private val citiesList = listOf(
        CityModel(0, "Warsaw", "Poland"),
        CityModel(1, "Wrocław", "Poland"),
        CityModel(2, "Gdańsk", "Poland"),
        CityModel(3, "Poznań", "Poland"),
        CityModel(4, "Bydgoszcz", "Poland"),
        CityModel(5, "Toruń", "Poland"),
        CityModel(6, "Białystok", "Poland"),
        CityModel(7, "Zielona Góra", "Poland"),
        CityModel(8, "Denver", "America"),
        CityModel(9, "Detroit", "America"),
        CityModel(10, "New York", "America"),
        CityModel(11, "Washington, D.C.", "America"),
        CityModel(12, "Houston", "America"),
        CityModel(13, "Las Vegas", "America"),
        CityModel(14, "Miami", "America"),
        CityModel(15, "El paso", "America"),
        CityModel(16, "Pasadena", "America"),
        CityModel(17, "Chicago", "America"),
        CityModel(18, "San Francisco", "America"),
        CityModel(19, "Boston", "America")
    )

    private val searchCityAdapter by lazy {
        SearchCityAdapter {

        }
    }

    private lateinit var viewModel: SearchCityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_city_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        citiesRecyclerView.adapter = searchCityAdapter.apply {
            submitList(citiesList)
        }
        citiesRecyclerView.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SearchCityViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
