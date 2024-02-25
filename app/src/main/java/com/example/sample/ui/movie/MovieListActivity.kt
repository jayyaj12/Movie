package com.example.sample.ui.movie

import android.os.Bundle
import com.example.sample.R
import com.example.sample.base.BaseActivity
import com.example.sample.databinding.ActivityMovieListBinding
import com.example.sample.ext.addFragment
import com.example.sample.ui.movie.popular.MoviePopularFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListActivity: BaseActivity<ActivityMovieListBinding, MovieListViewModel>(R.layout.activity_movie_list) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupShowFragment()
    }

    override fun setupObserver() {
    }

    private fun setupShowFragment() {
        this.addFragment(
            fragment = MoviePopularFragment(),
            containerViewId = R.id.fl_movie_container
        )
    }

}