package com.example.yumarketforowners.data.remote.dto.order

import com.example.yumarketforowners.domain.model.order.DeliveryType
import com.example.yumarketforowners.domain.model.order.OrderState
import java.time.LocalTime

// CRU
data class OrderDto(
    val id: Long, // not updatable
    val marketId: Long, // not updatable
    val orderedAt: Long, // not updatable
    val orderItemDtos: List<OrderItemDto>, // not updatable
    val totalPrice: Int, // not updatable
    val orderState: OrderState,
    val deliveryFee: Int, // not updatable
    val deliveryTime: Pair<LocalTime, LocalTime>, // only updatable when delivery completes
    val deliveryType: DeliveryType, // not updatable
    val orderMakerId: Long, // not updatable
    val request: String // not updatable
)
