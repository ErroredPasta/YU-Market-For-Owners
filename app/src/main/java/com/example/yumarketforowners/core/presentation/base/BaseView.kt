package com.example.yumarketforowners.core.presentation.base

interface BaseView {
    fun loading(isLoading: Boolean)
    fun onError(throwable: Throwable)
}