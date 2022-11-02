package com.example.yumarketforowners.domain.repository

import com.example.yumarketforowners.domain.model.item.Item

interface ItemRepository {
    suspend fun getItemsByMarketId(marketId: Long): List<Item>
    suspend fun getSingleItemById(itemId: Long): Item
    suspend fun updateItem(updatedItem: Item)
}