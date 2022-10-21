package com.example.yumarketforowners.presentation.screen.orderlist

interface OrderListView {
    fun onError(throwable: Throwable)
    fun onRequestDataSuccess(data: List<OrderUiState>)
    fun loading(isLoading: Boolean)
    fun navigateToCallScreen(telephoneNumber: String)
}