package com.example.yumarketforowners.domain.usecase.item

import com.example.yumarketforowners.domain.repository.ItemRepository

class GetItemsUseCase(
    private val repository: ItemRepository
) {
    suspend operator fun invoke(
        marketId: Long,
        available: Boolean
    ) = repository.getItemsByMarketId(marketId).filter { it.available == available }
}