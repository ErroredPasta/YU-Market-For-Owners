package com.example.yumarketforowners.data.repository.item

import com.example.yumarketforowners.di.singleton.Dispatcher
import com.example.yumarketforowners.di.singleton.DispatcherType
import com.example.yumarketforowners.domain.model.itemmanage.Item
import com.example.yumarketforowners.domain.repository.ItemRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    @Dispatcher(DispatcherType.IO) private val dispatcher: CoroutineDispatcher
) : ItemRepository {
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

    override suspend fun getItemsByMarketId(marketId: Long): List<Item> =
        withContext(dispatcher) {
            testList
        }
}