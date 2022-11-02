package com.example.yumarketforowners.domain.usecase.item

import com.example.yumarketforowners.domain.repository.ItemRepository

class GetSingleItemUseCase(
    private val repository: ItemRepository
) {
    suspend operator fun invoke(itemId: Long) = repository.getSingleItemById(itemId = itemId)
}
