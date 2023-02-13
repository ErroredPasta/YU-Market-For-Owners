package com.example.yumarketforowners.orderlist.data.datasource

import com.example.yumarketforowners.orderlist.data.dto.OrderDto
import com.example.yumarketforowners.orderlist.domain.model.OrderState
import kotlinx.coroutines.flow.Flow

interface OrderRemoteDataSource {
    val orderListFlow: Flow<List<OrderDto>>
    suspend fun getOrderListByMarketId(marketId: String): List<OrderDto>
    suspend fun getOrderByOrderId(orderId: Long): OrderDto?
    suspend fun updateOrderState(orderId: Long, orderState: OrderState)
}