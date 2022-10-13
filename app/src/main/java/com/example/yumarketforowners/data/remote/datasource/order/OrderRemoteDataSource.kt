package com.example.yumarketforowners.data.remote.datasource.order

import com.example.yumarketforowners.data.remote.dto.order.OrderDto

interface OrderRemoteDataSource {
    suspend fun getOrderListByMarketId(marketId: Long): List<OrderDto>
    suspend fun getOrderByOrderId(orderId: Long): OrderDto?
}