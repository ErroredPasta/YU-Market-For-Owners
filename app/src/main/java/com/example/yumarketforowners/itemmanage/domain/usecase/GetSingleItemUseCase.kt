package com.example.yumarketforowners.itemmanage.domain.usecase

import com.example.yumarketforowners.itemmanage.domain.repository.ItemRepository

class GetSingleItemUseCase(
    private val repository: ItemRepository
) {
    suspend operator fun invoke(itemId: Long) = repository.getSingleItemById(itemId = itemId)
}
