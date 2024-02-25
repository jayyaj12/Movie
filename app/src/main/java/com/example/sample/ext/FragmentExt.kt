package com.example.sample.ext

import android.os.Bundle
import android.util.Log
import androidx.annotation.IdRes
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.sample.R
import com.example.sample.ui.movie.MovieConstant
import com.example.sample.ui.movie.MovieConstant.REQUEST_PARAM
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

fun Fragment.onReplaceFragment(
    fragment: Fragment,
    @IdRes containerViewId: Int,
    addBackStack: Boolean = false
) {
    this.parentFragmentManager.beginTransaction().apply {
        replace(containerViewId, fragment)
        if (addBackStack) addToBackStack(fragment.tag)
        setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        commit()
    }
}

fun Fragment.popFragment() {
    Timber.e("this.parentFragmentManager.backStackEntryCount ${this.parentFragmentManager.backStackEntryCount}")
    if (this.parentFragmentManager.backStackEntryCount == 0) {
        requireActivity().finish()
    } else {
        this.parentFragmentManager.popBackStack()
    }
}