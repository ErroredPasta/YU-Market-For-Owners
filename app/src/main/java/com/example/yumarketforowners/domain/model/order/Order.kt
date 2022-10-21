package com.example.yumarketforowners.domain.model.order

import java.time.LocalTime

data class Order(
    val id: Long,
    val orderedAt: Long,
    val orderItems: List<OrderItem>,
    val totalPrice: Int,
    val orderState: OrderState,
    val deliveryFee: Int,
    val deliveryTime: Pair<LocalTime, LocalTime>,
    val deliveryType: DeliveryType,
    val telephoneNumber: String,
    val request: String
)