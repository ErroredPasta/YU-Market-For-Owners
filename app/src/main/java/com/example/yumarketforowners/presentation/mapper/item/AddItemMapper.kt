package com.example.yumarketforowners.presentation.mapper.item

import com.example.yumarketforowners.domain.model.item.Item
import com.example.yumarketforowners.presentation.screen.itemmanage.additem.AddItemUiState
import com.example.yumarketforowners.presentation.screen.itemmanage.updateitem.OptionGroupUiState

fun AddItemUiState.toItem(
    optionGroups: List<OptionGroupUiState>
) = Item(
    id = 0L,
    name = name,
    description = description,
    stock = stock,
    price = price,
    discountedPrice = discountedPrice,
    imageUrl = imageUrl,
    optionGroups = optionGroups.toOptionGroups(),
    available = available
)