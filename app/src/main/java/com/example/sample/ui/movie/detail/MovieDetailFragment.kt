package com.example.sample.ui.movie.detail

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.navArgs
import com.example.sample.R
import com.example.sample.base.BaseFragment
import com.example.sample.databinding.FragmentMovieDetailBinding
import com.example.sample.model.UiMoviePopular
import com.example.sample.ui.movie.MovieConstant
import com.example.sample.ui.movie.MovieConstant.REQUEST_PARAM
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MovieDetailFragment: BaseFragment<FragmentMovieDetailBinding, MovieDetailViewModel>(R.layout.fragment_movie_detail){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setupObserver() {}

}