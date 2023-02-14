package com.example.yumarketforowners.itemmanage.domain.usecase

import com.example.yumarketforowners.itemmanage.domain.repository.ItemRepository
import javax.inject.Inject

class GetSingleItemUseCase @Inject constructor(
    private val repository: ItemRepository
) {
    suspend operator fun invoke(itemId: Long) = repository.getSingleItemById(itemId = itemId)
}
