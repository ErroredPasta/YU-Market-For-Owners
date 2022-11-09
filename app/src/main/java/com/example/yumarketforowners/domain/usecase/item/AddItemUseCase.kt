package com.example.yumarketforowners.domain.usecase.item

import com.example.yumarketforowners.domain.model.item.Item
import com.example.yumarketforowners.domain.repository.ItemRepository
import com.example.yumarketforowners.domain.validator.ItemValidator

class AddItemUseCase(
    private val repository: ItemRepository
) {
    suspend operator fun invoke(itemToAdd: Item) {
        ItemValidator.validateItem(item = itemToAdd)
        repository.addItem(itemToAdd = itemToAdd)
    }
}
