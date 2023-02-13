package com.example.yumarketforowners.itemmanage.presentation.mapper

import com.example.yumarketforowners.itemmanage.domain.model.Item
import com.example.yumarketforowners.itemmanage.presentation.screen.additem.AddItemUiState
import com.example.yumarketforowners.itemmanage.presentation.viewholder.OptionGroupUiState

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