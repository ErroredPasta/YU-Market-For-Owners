package com.example.yumarketforowners.data.repository

import com.example.yumarketforowners.domain.model.itemmanage.Item
import com.example.yumarketforowners.domain.repository.ItemRepository

class FakeItemRepository : ItemRepository {
    private val items = (1..10).map {
        Item(
            id = it.toLong(),
            name = "name $it",
            count = it,
            price = it,
            saleRatio = it,
            imageUrl = "imageUrl $it",
            available = it % 2 == 0
        )
    }.toMutableList()

    override suspend fun getItemsByMarketId(marketId: Long): List<Item> = items
}