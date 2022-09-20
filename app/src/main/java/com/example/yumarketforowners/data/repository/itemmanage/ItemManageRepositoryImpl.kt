package com.example.yumarketforowners.data.repository.itemmanage

import com.example.yumarketforowners.domain.model.itemmanage.Item
import com.example.yumarketforowners.domain.repository.ItemManageRepository
import javax.inject.Inject

class ItemManageRepositoryImpl @Inject constructor() : ItemManageRepository {
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

    override fun getItemsByMarketId(marketId: Long): List<Item> = testList
}