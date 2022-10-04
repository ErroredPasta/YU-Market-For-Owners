package com.example.yumarketforowners.data.repository.order

import com.example.yumarketforowners.data.remote.order.OrderRemoteDataSource
import com.example.yumarketforowners.domain.repository.OrderRepository
import javax.inject.Inject


class OrderRepositoryImpl @Inject constructor(
    private val remoteDatasource: OrderRemoteDataSource
) : OrderRepository {

    override suspend fun getOrderListByMarketId(marketId: Long) =
        remoteDatasource.getOrderListByMarketId(marketId)
}