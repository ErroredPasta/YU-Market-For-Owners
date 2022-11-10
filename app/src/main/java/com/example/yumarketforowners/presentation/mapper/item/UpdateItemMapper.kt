package com.example.yumarketforowners.presentation.mapper.item

import com.example.yumarketforowners.domain.model.item.Item
import com.example.yumarketforowners.presentation.screen.itemmanage.updateitem.UpdateItemUiState
import com.example.yumarketforowners.presentation.viewholder.itemmanage.OptionGroupUiState

fun Item.toUpdateItemUiState() = UpdateItemUiState(
    id = id,
    name = name,
    description = description,
    stock = stock,
    price = price,
    discountedPrice = discountedPrice,
    imageUrl = imageUrl,
    available = available
)

fun UpdateItemUiState.toItem(
    optionGroupUiStates: List<OptionGroupUiState>
) = Item(
    id = id,
    name = name,
    description = description,
    stock = stock,
    price = price,
    discountedPrice = discountedPrice,
    imageUrl = imageUrl,
    optionGroups = optionGroupUiStates.toOptionGroups(),
    available = available
)