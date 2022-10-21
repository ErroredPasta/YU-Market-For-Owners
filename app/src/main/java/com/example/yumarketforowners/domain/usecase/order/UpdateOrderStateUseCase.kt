package com.example.yumarketforowners.domain.usecase.order

import com.example.yumarketforowners.domain.model.order.OrderState
import com.example.yumarketforowners.domain.repository.OrderRepository

class UpdateOrderStateUseCase(
    private val repository: OrderRepository
) {
    suspend operator fun invoke(
        orderId: Long,
        orderState: OrderState
    ) = repository.updateOrderState(orderId, orderState)
}