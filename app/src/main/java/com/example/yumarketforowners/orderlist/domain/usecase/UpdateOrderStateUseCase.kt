package com.example.yumarketforowners.orderlist.domain.usecase

import com.example.yumarketforowners.orderlist.domain.model.OrderState
import com.example.yumarketforowners.orderlist.domain.repository.OrderRepository
import javax.inject.Inject

class UpdateOrderStateUseCase @Inject constructor(
    private val repository: OrderRepository
) {
    suspend operator fun invoke(
        orderId: Long,
        orderState: OrderState
    ) = repository.updateOrderState(orderId, orderState)
}