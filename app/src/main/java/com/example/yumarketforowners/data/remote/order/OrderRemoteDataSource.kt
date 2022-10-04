package com.example.yumarketforowners.data.remote.order

import com.example.yumarketforowners.domain.model.orderlist.Order

interface OrderRemoteDataSource {
    suspend fun getOrderListByMarketId(marketId: Long): List<Order>
}