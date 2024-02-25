package com.example.sample.ui

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.example.sample.BR
import com.example.sample.R
import com.example.sample.base.BaseActivity
import com.example.sample.databinding.ActivityMainBinding
import com.example.sample.ext.addFragment
import com.example.sample.model.UiWord
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main,
), UiWord.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupUi()
    }

    private fun setupUi() {
        binding.setVariable(BR.eventHolder, this)
        binding.rvWord.addOnScrollListener(object : OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                binding.rvWord.layoutManager?.let {
                    val totalItemCount = it.itemCount
                    val visibleItemCount = it.childCount
                    val lastVisibleItemPosition =
                        (it as LinearLayoutManager).findLastVisibleItemPosition()

                    if (visibleItemCount + lastVisibleItemPosition + VISIBLE_THRESHOLD >= totalItemCount) {
                        viewModel.getWords()
                    }
                }
            }
        })
    }

    override fun onItemClick(item: UiWord) {
        Toast.makeText(this, "item#${item.id} ${item.value} is clicked!", Toast.LENGTH_LONG).show()
    }

    override fun setupObserver() {
    }

    companion object {
        private const val VISIBLE_THRESHOLD = 5
    }
}