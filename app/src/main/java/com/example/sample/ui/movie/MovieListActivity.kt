package com.example.sample.ui.movie

import android.os.Bundle
import com.example.sample.BR
import com.example.sample.R
import com.example.sample.base.BaseActivity
import com.example.sample.databinding.ActivityMovieListBinding
import com.example.sample.ext.addFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListActivity: BaseActivity<ActivityMovieListBinding, MovieListViewModel>(R.layout.activity_movie_list) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun setupObserver() {
        this.addFragment(
            fragment = MoviePopularFragment(),
            containerViewId = R.id.fl_movie_container
        )
    }

}