package com.example.yumarketforowners.data.repository.order

import com.example.yumarketforowners.data.mapper.order.toOrder
import com.example.yumarketforowners.data.remote.datasource.order.OrderRemoteDataSource
import com.example.yumarketforowners.domain.model.order.Order
import com.example.yumarketforowners.domain.model.order.OrderState
import com.example.yumarketforowners.domain.repository.OrderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class OrderRepositoryImpl @Inject constructor(
    private val remoteDatasource: OrderRemoteDataSource
) : OrderRepository {

    override val orderListFlow: Flow<List<Order>> = remoteDatasource.orderListFlow.map {
        it.map { orderDto -> orderDto.toOrder() }
    }

    override suspend fun getOrderListByMarketId(marketId: Long): List<Order> =
        remoteDatasource.getOrderListByMarketId(marketId).map { it.toOrder() }

    override suspend fun getOrderById(orderId: Long) =
        remoteDatasource.getOrderByOrderId(orderId)?.toOrder()

    override suspend fun updateOrderState(
        orderId: Long,
        orderState: OrderState
    ) = remoteDatasource.updateOrderState(orderId, orderState)
}