package com.example.yumarketforowners.presentation.recyclerview.listener.orderlist

import com.example.yumarketforowners.presentation.recyclerview.listener.AdapterListener
import com.example.yumarketforowners.presentation.screen.orderlist.OrderUiState

interface OrderViewHolderListener : AdapterListener {
    fun onTelePhoneNumberClicked(telephoneNumber: String)
    fun onAcceptOrderButtonClicked(order: OrderUiState)
    fun onRejectOrderButtonClicked(order: OrderUiState)
    fun onDeliveryDoneButtonClicked(order: OrderUiState)
}