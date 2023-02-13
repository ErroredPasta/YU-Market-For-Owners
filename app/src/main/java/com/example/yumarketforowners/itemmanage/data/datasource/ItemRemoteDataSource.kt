package com.example.yumarketforowners.itemmanage.data.datasource

import com.example.yumarketforowners.itemmanage.data.dto.ItemDto
import kotlinx.coroutines.flow.Flow

interface ItemRemoteDataSource {
    fun getItemsByMarketId(marketId: String): Flow<List<ItemDto>>
    suspend fun getSingleItemById(itemId: Long): ItemDto
    suspend fun updateItem(updatedItem: ItemDto)
    suspend fun addItem(itemToAdd: ItemDto)
}