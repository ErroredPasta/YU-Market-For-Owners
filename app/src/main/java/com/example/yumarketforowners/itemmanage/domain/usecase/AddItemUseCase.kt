package com.example.yumarketforowners.itemmanage.domain.usecase

import com.example.yumarketforowners.itemmanage.domain.model.Item
import com.example.yumarketforowners.itemmanage.domain.repository.ItemRepository
import com.example.yumarketforowners.itemmanage.domain.validator.ItemValidator
import javax.inject.Inject

class AddItemUseCase @Inject constructor(
    private val repository: ItemRepository
) {
    suspend operator fun invoke(itemToAdd: Item) {
        ItemValidator.validateItem(item = itemToAdd)
        repository.addItem(itemToAdd = itemToAdd)
    }
}
