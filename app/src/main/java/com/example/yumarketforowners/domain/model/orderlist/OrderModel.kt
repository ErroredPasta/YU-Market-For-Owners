package com.example.yumarketforowners.domain.model.orderlist

import com.example.yumarketforowners.presentation.recyclerview.viewholder.CellType
import com.example.yumarketforowners.domain.model.BaseModel
import com.example.yumarketforowners.domain.model.itemmanage.ItemModel
import com.example.yumarketforowners.presentation.screen.orderlist.OrderState

data class OrderModel(
    override val id: Long,
    val orderId: String,
    val orderItems: List<ItemModel>,
    val deliveryType: DeliveryType,
    val orderTime: Long,
    val telePhoneNumber: String,
    val request: String,
    var orderState: OrderState
) : BaseModel(id, CellType.ORDER_CELL)