package com.example.yumarketforowners.data.remote.datasource.order

import com.example.yumarketforowners.data.remote.dto.order.OrderDto
import com.example.yumarketforowners.domain.model.order.OrderState
import kotlinx.coroutines.flow.Flow

interface OrderRemoteDataSource {
    val orderListFlow: Flow<List<OrderDto>>
    suspend fun getOrderListByMarketId(marketId: Long): List<OrderDto>
    suspend fun getOrderByOrderId(orderId: Long): OrderDto?
    suspend fun updateOrderState(orderId: Long, orderState: OrderState)
}