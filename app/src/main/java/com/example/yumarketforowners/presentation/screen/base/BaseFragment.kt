package com.example.yumarketforowners.presentation.screen.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    private var _binding: VB? = null
    protected val binding: VB get() = _binding!!

    protected abstract fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = getViewBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initState()
    }

    override fun onDestroyView() {
        beforeDestroyView()
        _binding = null
        super.onDestroyView()
    }

    protected open fun initState() = Unit
    protected open fun beforeDestroyView() = Unit
}