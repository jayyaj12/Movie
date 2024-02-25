package com.example.sample.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sample.BR
import com.example.sample.R
import com.example.sample.base.BaseFragment
import com.example.sample.databinding.FragmentMoviePopularBinding
import com.example.sample.model.UiMoviePopular
import com.example.sample.ui.test.TestFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@AndroidEntryPoint
class MoviePopularFragment :BaseFragment<FragmentMoviePopularBinding, MoviePopularViewModel>(
        R.layout.fragment_movie_popular
), UiMoviePopular.OnItemClickListener {

    companion object {
        private const val VISIBLE_THRESHOLD = 5

        fun newInstance(): TestFragment = TestFragment()
    }

    override fun onItemClick(item: UiMoviePopular) {
        Timber.e("onItemClick: $item")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUi()
    }

    private fun setupUi() {
        binding.setVariable(BR.eventHolder, this)
        binding.rvMoviePopular.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                binding.rvMoviePopular.layoutManager?.let {
                    val totalItemCount = it.itemCount
                    val visibleItemCount = it.childCount
                    val lastVisibleItemPosition =
                        (it as LinearLayoutManager).findLastVisibleItemPosition()

                    if (visibleItemCount + lastVisibleItemPosition + VISIBLE_THRESHOLD >= totalItemCount) {
                        viewModel.getMoviePopular(SearchLanguage.KO)
                    }
                }
            }
        })
    }

}