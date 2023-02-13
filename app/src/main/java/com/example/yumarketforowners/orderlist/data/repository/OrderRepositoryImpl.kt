package com.example.yumarketforowners.orderlist.data.repository

import com.example.yumarketforowners.orderlist.data.mapper.toOrder
import com.example.yumarketforowners.orderlist.data.datasource.FakeOrderRemoteDataSource
import com.example.yumarketforowners.orderlist.data.datasource.FirebaseOrderRemoteDataSource
import com.example.yumarketforowners.orderlist.domain.model.Order
import com.example.yumarketforowners.orderlist.domain.model.OrderState
import com.example.yumarketforowners.orderlist.domain.repository.OrderRepository
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