package com.example.yumarketforowners.presentation.screen.base

interface BaseView {
    fun loading(isLoading: Boolean)
    fun onError(throwable: Throwable)
}