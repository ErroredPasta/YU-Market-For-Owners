package com.example.yumarketforowners.entity

import com.example.yumarketforowners.itemmanage.domain.model.Item
import com.example.yumarketforowners.itemmanage.domain.model.Option
import com.example.yumarketforowners.itemmanage.domain.model.OptionGroup

fun createItem(
    it: Int,
    available: Boolean = it % 2 == 0
) = Item(
    id = it.toLong(),
    name = "name $it",
    price = it * 20000,
    imageUrl = "imageUrl $it",
    available = available,
    description = "description $it",
    stock = it,
    discountedPrice = it * 10000,
    optionGroups = createOptionGroups((it..it + 3))
)

private fun createOptionGroups(range: IntRange) = range.map {
    OptionGroup(
        id = it.toLong(),
        name = "name $it",
        options = createOptions((it..it + 3)),
        selectRange = it..it + 2
    )
}

private fun createOptions(range: IntRange) = range.map {
    Option(
        id = it.toLong(),
        name = "name $it",
        additionalPrice = it * 1000
    )
}