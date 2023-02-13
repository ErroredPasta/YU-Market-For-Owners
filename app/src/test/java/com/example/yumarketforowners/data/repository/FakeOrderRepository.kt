package com.example.yumarketforowners.data.repository

import com.example.yumarketforowners.orderlist.domain.repository.OrderRepository
import com.example.yumarketforowners.entity.createOrder
import com.example.yumarketforowners.orderlist.domain.model.Order
import com.example.yumarketforowners.orderlist.domain.model.OrderState
import kotlinx.coroutines.flow.Flow

class FakeOrderRepository : OrderRepository {
    private val orders = (1..10).map {
        createOrder(it)
    }.toMutableList()
    override val orderListFlow: Flow<List<Order>>
        get() = TODO("Not yet implemented")

    override suspend fun getOrderListByMarketId(marketId: String): List<Order> = orders
    override suspend fun getOrderById(orderId: Long): Order? = orders.find { it.id == orderId }
    override suspend fun updateOrderState(orderId: Long, orderState: OrderState) {
        TODO("Not yet implemented")
    }
}