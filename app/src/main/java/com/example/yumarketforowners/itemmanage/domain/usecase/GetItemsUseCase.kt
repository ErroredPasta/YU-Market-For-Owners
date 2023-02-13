package com.example.yumarketforowners.itemmanage.domain.usecase

import com.example.yumarketforowners.itemmanage.domain.repository.ItemRepository
import kotlinx.coroutines.flow.map

class GetItemsUseCase(
    private val repository: ItemRepository
) {
    operator fun invoke(
        marketId: String,
        available: Boolean
    ) = repository.getItemsByMarketId(marketId).map { items ->
        items.filter { item -> item.available == available }
    }
}