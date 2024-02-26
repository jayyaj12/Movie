package com.example.sample.ui.movie.list

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import com.example.sample.R
import com.example.sample.base.BaseActivity
import com.example.sample.databinding.ActivityMovieListBinding
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class MovieListActivity: BaseActivity<ActivityMovieListBinding, MovieListViewModel>(R.layout.activity_movie_list) {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupJetpackNavigation()

    }

    private fun setupJetpackNavigation() {
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.movieListActivity,
            R.id.movieDetailFragment,
        ))

//        navController.addOnDestinationChangedListener { controller, destination, arguments ->
//            binding.navHostFragmentContainer.isVisible = appBarConfiguration.topLevelDestinations.contains(destination.id)
//        }

        val host = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = host.navController
    }

    override fun setupObserver() {}

}

