package com.example.weatheracc.ui.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.example.weatheracc.R
import com.example.weatheracc.viewmodels.ForecastListViewModel
import kotlinx.android.synthetic.main.forecast_list_fragment.*


class ForecastListFragment : Fragment() {

    private lateinit var viewModel: ForecastListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().onBackPressedDispatcher.addCallback(this,
        object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        })
        return inflater.inflate(R.layout.forecast_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addLocationButton.setOnClickListener {
            findNavController().navigate(ForecastListFragmentDirections.actionForecastListFragmentToSearchFragment())
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ForecastListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
