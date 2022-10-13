package com.example.yumarketforowners.data.mapper.item

import com.example.yumarketforowners.data.remote.dto.item.ItemDto
import com.example.yumarketforowners.data.remote.dto.item.OptionDto
import com.example.yumarketforowners.data.remote.dto.item.OptionGroupDto
import com.example.yumarketforowners.domain.model.item.Item
import com.example.yumarketforowners.domain.model.item.Option
import com.example.yumarketforowners.domain.model.item.OptionGroup

fun Item.toItemDto() = ItemDto(
    id = id,
    name = name,
    description = description,
    stock = stock,
    price = price,
    discountedPrice = discountedPrice,
    imageUrl = imageUrl,
    optionGroups = optionGroups.toOptionGroupDtos(),
    available = available
)

fun ItemDto.toItem() = Item(
    id = id,
    name = name,
    description = description,
    stock = stock,
    price = price,
    discountedPrice = discountedPrice,
    imageUrl = imageUrl,
    optionGroups = optionGroups.toOptionGroups(),
    available = available
)

private fun List<Option>.toOptionDtos() = map {
    OptionDto(
        id = it.id,
        name = it.name
    )
}

private fun List<OptionGroup>.toOptionGroupDtos() = map {
    OptionGroupDto(
        id = it.id,
        options = it.options.toOptionDtos(),
        selectRange = it.selectRange
    )
}

private fun List<OptionDto>.toOptions() = map {
    Option(
        id = it.id,
        name = it.name
    )
}

private fun List<OptionGroupDto>.toOptionGroups() = map {
    OptionGroup(
        id = it.id,
        options = it.options.toOptions(),
        selectRange = it.selectRange
    )
}