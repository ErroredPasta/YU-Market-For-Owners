package com.example.yumarketforowners.domain.usecase.item

import com.example.yumarketforowners.domain.repository.ItemRepository
import kotlinx.coroutines.flow.map

class GetItemsUseCase(
    private val repository: ItemRepository
) {
    operator fun invoke(
        marketId: Long,
        available: Boolean
    ) = repository.getItemsByMarketId(marketId).map { items ->
        items.filter { item -> item.available == available }
    }
}