package com.example.yumarketforowners.domain.repository

import com.example.yumarketforowners.domain.model.orderlist.OrderModel

interface OrderListRepository {
    fun getOrderListByMarketId(marketId: Long): List<OrderModel>
}