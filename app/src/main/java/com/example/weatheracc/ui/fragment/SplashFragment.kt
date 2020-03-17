package com.example.weatheracc.ui.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.weatheracc.R
import com.example.weatheracc.viewmodels.SplashViewModel

class SplashFragment : Fragment() {

    private lateinit var viewModel: SplashViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.splash_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        Handler().postDelayed({
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToForecastListFragment())
        },3000)
    }

}
