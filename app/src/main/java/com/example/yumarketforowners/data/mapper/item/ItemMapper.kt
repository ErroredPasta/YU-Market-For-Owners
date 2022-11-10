package com.example.yumarketforowners.data.mapper.item

import com.example.yumarketforowners.data.remote.dto.item.ItemDto
import com.example.yumarketforowners.domain.model.item.Item

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