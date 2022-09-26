package com.example.yumarketforowners.domain.usecase.order

import com.example.yumarketforowners.domain.repository.OrderRepository
import com.example.yumarketforowners.domain.model.orderlist.OrderState

class GetOrderList(
    private val repository: OrderRepository
) {
    suspend operator fun invoke(
        marketId: Long,
        orderState: OrderState
    ) = repository.getOrderListByMarketId(marketId)?.filter { it.orderState == orderState }
}