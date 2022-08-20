package com.example.yumarketforowners.domain.repository

import com.example.yumarketforowners.presentation.screen.orderlist.OrderListContract

interface OrderListRepository {
    fun getOrderListByMarketId(marketId: Long): OrderListContract.State
}