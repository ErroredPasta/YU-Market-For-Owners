package com.example.yumarketforowners.presentation.screen.orderlist

import androidx.annotation.StringRes

interface OrderListView {
    fun onRequestDataError(@StringRes errorMessage: Int)
    fun onRequestDataSuccess(data: List<OrderUiState>)
    fun loading(isLoading: Boolean)
    fun navigateToCallScreen(telephoneNumber: String)
}