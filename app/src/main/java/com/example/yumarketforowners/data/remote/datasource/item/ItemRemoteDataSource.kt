package com.example.yumarketforowners.data.remote.datasource.item

import com.example.yumarketforowners.data.remote.dto.item.ItemDto

interface ItemRemoteDataSource {
    suspend fun getItemsByMarketId(marketId: Long): List<ItemDto>
}