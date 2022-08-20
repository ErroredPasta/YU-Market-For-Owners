package com.example.yumarketforowners.presentation.recyclerview.listener.orderlist

import com.example.yumarketforowners.presentation.recyclerview.listener.AdapterListener
import com.example.yumarketforowners.domain.model.orderlist.OrderModel

interface OrderViewHolderListener : AdapterListener {
    fun onTelePhoneNumberClicked(telePhoneNumber: String)
    fun onAcceptOrderButtonClicked(order: OrderModel)
    fun onRejectOrderButtonClicked(order: OrderModel)
    fun onDeliveryDoneButtonClicked(order: OrderModel)
}