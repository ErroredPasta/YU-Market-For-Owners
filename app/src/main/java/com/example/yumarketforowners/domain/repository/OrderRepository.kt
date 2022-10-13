package com.example.yumarketforowners.domain.repository

import com.example.yumarketforowners.domain.model.order.Order

interface OrderRepository {
    suspend fun getOrderListByMarketId(marketId: Long): List<Order>?
    suspend fun getOrderById(orderId: Long): Order?
}