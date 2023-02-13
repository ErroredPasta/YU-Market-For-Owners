package com.example.yumarketforowners.orderlist.domain.repository

import com.example.yumarketforowners.orderlist.domain.model.Order
import com.example.yumarketforowners.orderlist.domain.model.OrderState
import kotlinx.coroutines.flow.Flow

interface OrderRepository {
    val orderListFlow: Flow<List<Order>>
    suspend fun getOrderListByMarketId(marketId: String): List<Order>
    suspend fun getOrderById(orderId: Long): Order?
    suspend fun updateOrderState(orderId: Long, orderState: OrderState)
}