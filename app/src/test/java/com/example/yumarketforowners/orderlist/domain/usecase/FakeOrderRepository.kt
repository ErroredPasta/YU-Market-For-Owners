package com.example.yumarketforowners.orderlist.domain.usecase

import com.example.yumarketforowners.orderlist.createOrder
import com.example.yumarketforowners.orderlist.domain.model.Order
import com.example.yumarketforowners.orderlist.domain.model.OrderState
import com.example.yumarketforowners.orderlist.domain.repository.OrderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeOrderRepository : OrderRepository {

    private val orders = (1..10).map {
        createOrder(it)
    }.toMutableList()


    override val orderListFlow: Flow<List<Order>> get() = flowOf(orders)

    override suspend fun getOrderListByMarketId(marketId: String): List<Order> = orders
    override suspend fun getOrderById(orderId: Long): Order? = orders.find { it.id == orderId }
    override suspend fun updateOrderState(orderId: Long, orderState: OrderState) {
        val index = orders.indexOfFirst { it.id == orderId }

        if (index != -1) orders[index] = orders[index].copy(orderState = orderState)
    }
}