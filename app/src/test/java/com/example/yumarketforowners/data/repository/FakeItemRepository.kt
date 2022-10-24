package com.example.yumarketforowners.data.repository

import com.example.yumarketforowners.domain.model.item.Item
import com.example.yumarketforowners.domain.repository.ItemRepository
import com.example.yumarketforowners.entity.createItem

class FakeItemRepository : ItemRepository {
    private val items = (1..10).map {
        createItem(it)
    }.toMutableList()

    override suspend fun getItemsByMarketId(marketId: Long): List<Item> = items
}