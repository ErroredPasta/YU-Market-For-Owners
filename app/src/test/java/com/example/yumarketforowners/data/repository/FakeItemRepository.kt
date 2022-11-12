package com.example.yumarketforowners.data.repository

import com.example.yumarketforowners.domain.model.item.Item
import com.example.yumarketforowners.domain.repository.ItemRepository
import com.example.yumarketforowners.entity.createItem
import kotlinx.coroutines.flow.Flow

class FakeItemRepository : ItemRepository {
    private val items = (1..10).map {
        createItem(it)
    }.toMutableList()

    override fun getItemsByMarketId(marketId: String): Flow<List<Item>> {
        TODO("Not yet implemented")
    }
    override suspend fun getSingleItemById(itemId: Long): Item {
        val foundItem = items.find { it.id == itemId }

        return checkNotNull(foundItem) { "id가 ${itemId}인 Item이 없습니다." }
    }

    override suspend fun updateItem(updatedItem: Item) {
        val index = items.indexOfFirst { it.id == updatedItem.id }

        if (index != -1) {
            items[index] = updatedItem
        }
    }

    override suspend fun addItem(itemToAdd: Item) {
        TODO("Not yet implemented")
    }
}