package com.example.yumarketforowners.itemmanage.domain.repository

import com.example.yumarketforowners.itemmanage.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    fun getItemsByMarketId(marketId: String): Flow<List<Item>>
    suspend fun getSingleItemById(itemId: Long): Item
    suspend fun updateItem(updatedItem: Item)
    suspend fun addItem(itemToAdd: Item)
}