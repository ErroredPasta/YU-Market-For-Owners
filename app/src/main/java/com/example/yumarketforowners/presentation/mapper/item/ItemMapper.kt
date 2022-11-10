package com.example.yumarketforowners.presentation.mapper.item

import com.example.yumarketforowners.domain.model.item.Item
import com.example.yumarketforowners.presentation.viewholder.itemmanage.ItemUiState

fun Item.toItemUiState(
    onEditItemButtonClick: () -> Unit
) = ItemUiState(
    id = id,
    name = name,
    description = description,
    price = price,
    discountedPrice = discountedPrice,
    stock = stock,
    discountRatio = (price - discountedPrice) / 100,
    imageUrl = imageUrl,
    optionGroups = optionGroups,
    available = available,
    onEditItemButtonClick = onEditItemButtonClick
)

fun ItemUiState.toItem() = Item(
    id = id,
    name = name,
    description = description,
    stock = stock,
    price = price,
    discountedPrice = discountedPrice,
    imageUrl = imageUrl,
    optionGroups = optionGroups,
    available = available
)