package com.example.sample.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelLazy
import com.example.sample.BR
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<B : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes private val layoutResId: Int,
) : Fragment(layoutResId) {

    private var _binding: B? = null
    protected val binding: B
        get() = _binding!!

    private val viewModelClass = ((javaClass.genericSuperclass as ParameterizedType?)
        ?.actualTypeArguments
        ?.get(1) as Class<VM>).kotlin

    protected open val viewModel by ViewModelLazy(
        viewModelClass,
        { viewModelStore },
        { defaultViewModelProviderFactory },
        { defaultViewModelCreationExtras },
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        _binding = DataBindingUtil.bind(view!!)!!
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUi()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun setupUi() {
        with(binding) {
            setVariable(BR.vm, viewModel)
            lifecycleOwner = viewLifecycleOwner
        }
    }

}