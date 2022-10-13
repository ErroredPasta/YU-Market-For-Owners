package com.example.yumarketforowners.data.repository

import com.example.yumarketforowners.domain.model.order.*
import com.example.yumarketforowners.domain.repository.OrderRepository
import com.example.yumarketforowners.entity.createOrder
import java.time.LocalTime

class FakeOrderRepository : OrderRepository {
    private val orders = (1..10).map {
        createOrder(it)
    }.toMutableList()

    override suspend fun getOrderListByMarketId(marketId: Long): List<Order> = orders
    override suspend fun getOrderById(orderId: Long): Order? = orders.find { it.id == orderId }
}