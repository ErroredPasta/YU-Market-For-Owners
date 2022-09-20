package com.example.yumarketforowners.domain.repository

import com.example.yumarketforowners.domain.model.orderlist.Order

interface OrderListRepository {
    fun getOrderListByMarketId(marketId: Long): List<Order>
}