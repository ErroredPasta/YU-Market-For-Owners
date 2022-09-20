package com.example.yumarketforowners.domain.repository

import com.example.yumarketforowners.domain.model.itemmanage.Item

interface ItemRepository {
    suspend fun getItemsByMarketId(marketId: Long): List<Item>
}