package com.example.yumarketforowners.orderlist.presentation.screen

import com.example.yumarketforowners.core.presentation.base.BaseView
import com.example.yumarketforowners.orderlist.presentation.viewholder.OrderUiState

interface OrderListView : BaseView {
    fun onRequestDataSuccess(data: List<OrderUiState>)
    fun navigateToCallScreen(telephoneNumber: String)
}