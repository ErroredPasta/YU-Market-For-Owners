package com.example.yumarketforowners.presentation.recyclerview.listener.orderlist

import com.example.yumarketforowners.presentation.recyclerview.listener.AdapterListener
import com.example.yumarketforowners.domain.model.orderlist.Order

interface OrderViewHolderListener : AdapterListener {
    fun onTelePhoneNumberClicked(telePhoneNumber: String)
    fun onAcceptOrderButtonClicked(order: Order)
    fun onRejectOrderButtonClicked(order: Order)
    fun onDeliveryDoneButtonClicked(order: Order)
}