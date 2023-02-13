package com.example.yumarketforowners.itemmanage.presentation.mapper

import com.example.yumarketforowners.itemmanage.domain.model.Item
import com.example.yumarketforowners.itemmanage.presentation.screen.updateitem.UpdateItemUiState
import com.example.yumarketforowners.itemmanage.presentation.viewholder.OptionGroupUiState

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