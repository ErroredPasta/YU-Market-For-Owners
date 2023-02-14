package com.example.yumarketforowners.orderlist.domain.usecase

import com.example.yumarketforowners.orderlist.domain.model.OrderState
import com.example.yumarketforowners.orderlist.domain.repository.OrderRepository
import javax.inject.Inject

class GetOrderListUseCase @Inject constructor(
    private val repository: OrderRepository
) {
    suspend operator fun invoke(
        marketId: String,
        orderState: OrderState
    ) = repository.getOrderListByMarketId(marketId).filter { it.orderState == orderState }
}