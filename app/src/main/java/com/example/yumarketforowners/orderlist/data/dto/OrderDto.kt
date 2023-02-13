package com.example.yumarketforowners.orderlist.data.dto

import java.time.LocalTime

// CRU
data class OrderDto(
    var id: Long = 0L, // not updatable
    var marketId: Long = 0L, // not updatable
    var orderedAt: Long = 0L, // not updatable
    var orderItemDtos: List<OrderItemDto> = emptyList(), // not updatable
    var totalPrice: Int = 0, // not updatable
    var orderState: String = "",
    var deliveryFee: Int = 0, // not updatable
    var deliveryTime: Pair<LocalTime, LocalTime> = LocalTime.now() to LocalTime.now(), // only updatable when delivery completes
    var deliveryType: String = "", // not updatable
    var orderMakerId: Long = 0L, // not updatable
    var request: String = ""// not updatable
)
