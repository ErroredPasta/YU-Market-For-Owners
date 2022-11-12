package com.example.yumarketforowners.data.repository.order

import com.example.yumarketforowners.data.mapper.order.toOrder
import com.example.yumarketforowners.data.remote.datasource.order.FakeOrderRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.order.FirebaseOrderRemoteDataSource
import com.example.yumarketforowners.domain.model.order.Order
import com.example.yumarketforowners.domain.model.order.OrderState
import com.example.yumarketforowners.domain.repository.OrderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


/* TODO: 2022-11-13 일 08:14, change parameter types to interfaces */
class OrderRepositoryImpl @Inject constructor(
    private val remoteDataSource: FirebaseOrderRemoteDataSource,
    private val fakeOrderRemoteDataSource: FakeOrderRemoteDataSource
) : OrderRepository {

    override val orderListFlow: Flow<List<Order>> = remoteDataSource.orderListFlow.map {
        it.map { orderDto -> orderDto.toOrder() }
    }

    override suspend fun getOrderListByMarketId(marketId: String): List<Order> =
        remoteDataSource.getOrderListByMarketId(marketId).map { it.toOrder() }

    override suspend fun getOrderById(orderId: Long) =
        fakeOrderRemoteDataSource.getOrderByOrderId(orderId)?.toOrder()

    override suspend fun updateOrderState(
        orderId: Long,
        orderState: OrderState
    ) = remoteDataSource.updateOrderState(orderId, orderState)
}