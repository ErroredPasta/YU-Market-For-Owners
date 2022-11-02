package com.example.yumarketforowners.data.remote.datasource.item

import com.example.yumarketforowners.data.remote.dto.item.ItemDto
import kotlinx.coroutines.flow.Flow

interface ItemRemoteDataSource {
    fun getItemsByMarketId(marketId: Long): Flow<List<ItemDto>>
    suspend fun getSingleItemById(itemId: Long): ItemDto
    suspend fun updateItem(updatedItem: ItemDto)
}