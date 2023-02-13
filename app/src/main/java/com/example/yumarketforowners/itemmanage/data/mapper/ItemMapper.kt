package com.example.yumarketforowners.itemmanage.data.mapper

import com.example.yumarketforowners.itemmanage.data.dto.ItemDto
import com.example.yumarketforowners.itemmanage.domain.model.Item

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