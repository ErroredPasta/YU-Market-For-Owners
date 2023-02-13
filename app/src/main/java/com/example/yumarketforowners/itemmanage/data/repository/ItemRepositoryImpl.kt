package com.example.yumarketforowners.itemmanage.data.repository

import com.example.yumarketforowners.itemmanage.data.mapper.toItem
import com.example.yumarketforowners.itemmanage.data.mapper.toItemDto
import com.example.yumarketforowners.itemmanage.data.datasource.ItemRemoteDataSource
import com.example.yumarketforowners.itemmanage.domain.model.Item
import com.example.yumarketforowners.itemmanage.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val remoteDataSource: ItemRemoteDataSource
) : ItemRepository {

    override fun getItemsByMarketId(marketId: String): Flow<List<Item>> =
        remoteDataSource.getItemsByMarketId(marketId).map {
            it.map { itemDto -> itemDto.toItem() }
        }

    override suspend fun getSingleItemById(itemId: Long): Item =
        remoteDataSource.getSingleItemById(itemId = itemId).toItem()

    override suspend fun updateItem(updatedItem: Item) =
        remoteDataSource.updateItem(updatedItem = updatedItem.toItemDto())

    override suspend fun addItem(itemToAdd: Item) {
        remoteDataSource.addItem(itemToAdd.toItemDto())
    }
}