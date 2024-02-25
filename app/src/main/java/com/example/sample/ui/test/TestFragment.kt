package com.example.sample.ui.test

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sample.BR
import com.example.sample.R
import com.example.sample.base.BaseFragment
import com.example.sample.databinding.FragmentTestBinding
import com.example.sample.model.UiWord
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestFragment : BaseFragment<FragmentTestBinding, TestViewModel>(
    R.layout.fragment_test
), UiWord.OnItemClickListener {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUi()
    }

    private fun setupUi() {
        binding.setVariable(BR.eventHolder, this)
        binding.rvWord.addOnScrollListener(object : RecyclerView.OnScrollListener() {
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

    override fun setupObserver() {}

    override fun onItemClick(item: UiWord) {
        Toast.makeText(context, "item#${item.id} ${item.value} is clicked!", Toast.LENGTH_LONG)
            .show()
    }

    companion object {
        private const val VISIBLE_THRESHOLD = 5

        fun newInstance(): TestFragment = TestFragment()
    }
}