package com.example.yumarketforowners.domain.usecase.order

import com.example.yumarketforowners.domain.model.order.OrderState
import com.example.yumarketforowners.domain.repository.OrderRepository

class GetOrderListUseCase(
    private val repository: OrderRepository
) {
    suspend operator fun invoke(
        marketId: String,
        orderState: OrderState
    ) = repository.getOrderListByMarketId(marketId).filter { it.orderState == orderState }
}