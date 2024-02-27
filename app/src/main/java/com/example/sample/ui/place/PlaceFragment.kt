package com.example.sample.ui.place

import android.os.Bundle
import android.view.View
import com.example.sample.R
import com.example.sample.base.BaseFragment
import com.example.sample.databinding.FragmentPlaceBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlaceFragment: BaseFragment<FragmentPlaceBinding, PlaceViewModel>(R.layout.fragment_place) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setupObserver() {}
}