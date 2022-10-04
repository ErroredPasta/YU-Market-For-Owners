package com.example.yumarketforowners.data.repository.item

import com.example.yumarketforowners.data.remote.item.ItemRemoteDataSource
import com.example.yumarketforowners.domain.repository.ItemRepository
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val remoteDataSource: ItemRemoteDataSource
) : ItemRepository {

    override suspend fun getItemsByMarketId(marketId: Long) =
        remoteDataSource.getItemsByMarketId(marketId)
}