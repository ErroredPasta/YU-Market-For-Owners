package com.example.yumarketforowners.domain.validator

import com.example.yumarketforowners.domain.model.item.Item
import com.example.yumarketforowners.domain.model.item.Option
import com.example.yumarketforowners.domain.model.item.OptionGroup

object ItemValidator {

    fun validateItem(item: Item) {
        check(item.name.isNotEmpty()) { "상품의 이름을 입력해주세요." }
        check(item.price > 0) { "상품의 가격을 올바르게 입력해주세요." }
        check(item.discountedPrice <= item.price) { "상품의 할인가를 올바르게 입력해주세요." }

        validateOptionGroups(optionGroups = item.optionGroups)
    }

    private fun validateOptionGroups(optionGroups: List<OptionGroup>) {
        for (optionGroup in optionGroups) {
            check(optionGroup.name.isNotEmpty()) { "옵션 그룹의 이름을 모두 입력해주세요." }
            check(!optionGroup.selectRange.isEmpty()) { "${optionGroup.name}의 선택 범위를 올바르게 입력해주세요." }
            check(optionGroup.selectRange.first <= optionGroups.size) {
                "${optionGroup.name}의 옵션 갯수가 최소 선택보다 작습니다."
            }

            validateOptions(options = optionGroup.options, optionGroupName = optionGroup.name)
        }
    }

    private fun validateOptions(options: List<Option>, optionGroupName: String) {
        for (option in options) {
            check(option.name.isNotEmpty()) { "${optionGroupName}의 옵션 이름을 모두 입력해주세요." }
            check(option.additionalPrice >= 0) { "${option.name}의 추가 가격을 올바르게 입력해주세요." }
        }
    }
}