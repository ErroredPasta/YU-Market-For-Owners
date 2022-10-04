package com.example.yumarketforowners.data.remote.item

import com.example.yumarketforowners.domain.model.itemmanage.Item

interface ItemRemoteDataSource {
    suspend fun getItemsByMarketId(marketId: Long): List<Item>
}