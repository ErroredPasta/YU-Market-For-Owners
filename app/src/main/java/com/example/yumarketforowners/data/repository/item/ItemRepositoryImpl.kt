package com.example.yumarketforowners.data.repository.item

import com.example.yumarketforowners.data.mapper.item.toItem
import com.example.yumarketforowners.data.remote.datasource.item.ItemRemoteDataSource
import com.example.yumarketforowners.domain.model.item.Item
import com.example.yumarketforowners.domain.repository.ItemRepository
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val remoteDataSource: ItemRemoteDataSource
) : ItemRepository {

    override suspend fun getItemsByMarketId(marketId: Long): List<Item> =
        remoteDataSource.getItemsByMarketId(marketId).map { it.toItem() }
}