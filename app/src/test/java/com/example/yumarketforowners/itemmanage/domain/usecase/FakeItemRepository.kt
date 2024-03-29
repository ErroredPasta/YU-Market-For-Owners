package com.example.yumarketforowners.itemmanage.domain.usecase

import com.example.yumarketforowners.itemmanage.domain.model.Item
import com.example.yumarketforowners.itemmanage.domain.repository.ItemRepository
import com.example.yumarketforowners.itemmanage.createItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeItemRepository : ItemRepository {
    private val items = (1..10).map {
        createItem(it)
    }.toMutableList()

    override fun getItemsByMarketId(marketId: String): Flow<List<Item>> = flowOf(items)

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