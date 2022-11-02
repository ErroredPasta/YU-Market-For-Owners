package com.example.yumarketforowners.domain.usecase.item

import com.example.yumarketforowners.domain.model.item.Item
import com.example.yumarketforowners.domain.model.item.Option
import com.example.yumarketforowners.domain.model.item.OptionGroup
import com.example.yumarketforowners.domain.repository.ItemRepository

class UpdateItemUseCase(
    private val repository: ItemRepository
) {
    suspend operator fun invoke(updatedItem: Item) {
        validateItem(item = updatedItem)
        repository.updateItem(updatedItem = updatedItem)
    }

    private fun validateItem(item: Item) {
        if (item.name.isEmpty()) {
            throw IllegalStateException("상품의 이름을 입력해주세요.")
        }

        if (item.price <= 0) {
            throw IllegalStateException("상품의 가격을 올바르게 입력해주세요.")
        }

        if (item.discountedPrice > item.price) {
            throw IllegalStateException("상품의 할인가를 올바르게 입력해주세요.")
        }

        validateOptionGroups(optionGroups = item.optionGroups)
    }

    private fun validateOptionGroups(optionGroups: List<OptionGroup>) {
        for (optionGroup in optionGroups) {
            if (optionGroup.name.isEmpty()) {
                throw IllegalStateException("옵션 그룹의 이름을 모두 입력해주세요.")
            }

            if (optionGroup.selectRange.isEmpty()) {
                throw IllegalStateException("${optionGroup.name}의 선택 범위를 올바르게 입력해주세요.")
            }

            validateOptions(options = optionGroup.options, optionGroupName = optionGroup.name)
        }
    }

    private fun validateOptions(options: List<Option>, optionGroupName: String) {
        for (option in options) {
            if (option.name.isEmpty()) {
                throw IllegalStateException("${optionGroupName}의 옵션 이름을 모두 입력해주세요.")
            }

            if (option.additionalPrice < 0) {
                throw IllegalStateException("${option.name}의 추가 가격을 올바르게 입력해주세요.")
            }
        }
    }
}
