package com.example.yumarketforowners.presentation.screen.orderlist

import com.example.yumarketforowners.presentation.screen.base.BaseView
import com.example.yumarketforowners.presentation.viewholder.orderlist.OrderUiState

interface OrderListView : BaseView {
    fun onRequestDataSuccess(data: List<OrderUiState>)
    fun navigateToCallScreen(telephoneNumber: String)
}