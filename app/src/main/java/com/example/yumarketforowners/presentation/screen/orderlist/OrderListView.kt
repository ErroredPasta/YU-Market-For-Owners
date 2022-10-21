package com.example.yumarketforowners.presentation.screen.orderlist

import androidx.annotation.StringRes

interface OrderListView {
    fun onError(@StringRes throwable: Throwable)
    fun onRequestDataSuccess(data: List<OrderUiState>)
    fun loading(isLoading: Boolean)
    fun navigateToCallScreen(telephoneNumber: String)
}