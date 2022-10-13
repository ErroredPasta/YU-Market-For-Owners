package com.example.yumarketforowners.domain.repository

import com.example.yumarketforowners.domain.model.item.Item

interface ItemRepository {
    suspend fun getItemsByMarketId(marketId: Long): List<Item>?
}