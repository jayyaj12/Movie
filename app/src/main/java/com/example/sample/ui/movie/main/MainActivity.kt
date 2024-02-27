package com.example.sample.ui.movie.main

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.sample.R
import com.example.sample.base.BaseActivity
import com.example.sample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {
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
        binding.bottomNav.setupWithNavController(navController)
    }

    override fun setupObserver() {}

}

