package com.example.yumarketforowners.data.remote.item

import com.example.yumarketforowners.domain.model.itemmanage.Item
import javax.inject.Inject

class FakeItemRemoteDataSource @Inject constructor() : ItemRemoteDataSource {

    private val testList
        get() = (0..9).map {
            Item(
                id = it.toLong(),
                count = it,
                name = "name $it",
                price = it * 10000,
                saleRatio = it,
                imageUrl = "https://picsum.photos/200",
                available = it % 2 == 0
            )
        }

    override suspend fun getItemsByMarketId(marketId: Long) = testList
}