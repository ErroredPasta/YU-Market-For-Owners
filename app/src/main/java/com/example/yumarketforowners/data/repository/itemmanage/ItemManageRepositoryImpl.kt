package com.example.yumarketforowners.data.repository.itemmanage

import com.example.yumarketforowners.domain.model.itemmanage.ItemModel
import com.example.yumarketforowners.domain.repository.ItemManageRepository
import javax.inject.Inject

class ItemManageRepositoryImpl @Inject constructor() : ItemManageRepository {
    private val testList
        get() = (0..9).map {
            ItemModel(
                id = it.toLong(),
                count = it,
                name = "name $it",
                price = it * 10000,
                saleRatio = it,
                imageUrl = "https://picsum.photos/200",
                available = it % 2 == 0
            )
        }

    override fun getItemsByMarketId(marketId: Long): List<ItemModel> = testList
}