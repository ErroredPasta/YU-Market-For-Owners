package com.example.yumarketforowners.data.repository.item

import com.example.yumarketforowners.data.mapper.item.toItem
import com.example.yumarketforowners.data.mapper.item.toItemDto
import com.example.yumarketforowners.data.remote.datasource.item.ItemRemoteDataSource
import com.example.yumarketforowners.domain.model.item.Item
import com.example.yumarketforowners.domain.repository.ItemRepository
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