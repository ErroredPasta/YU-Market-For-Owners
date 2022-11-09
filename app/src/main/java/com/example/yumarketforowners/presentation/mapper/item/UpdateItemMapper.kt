package com.example.yumarketforowners.presentation.mapper.item

import com.example.yumarketforowners.domain.model.item.Item
import com.example.yumarketforowners.domain.model.item.Option
import com.example.yumarketforowners.domain.model.item.OptionGroup
import com.example.yumarketforowners.presentation.screen.itemmanage.updateitem.OptionGroupUiState
import com.example.yumarketforowners.presentation.screen.itemmanage.updateitem.OptionUiState
import com.example.yumarketforowners.presentation.screen.itemmanage.updateitem.UpdateItemUiState

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

fun List<OptionGroup>.toOptionGroupUiStates(
    onDeleteOptionGroupButtonClicked: OptionGroupUiState.() -> Unit,
    onAddOptionButtonClicked: OptionGroupUiState.() -> Unit,
    onDeleteOptionButtonClicked: OptionUiState.() -> Unit
) = map {
    OptionGroupUiState(
        id = it.id,
        name = it.name,
        minSelect = it.selectRange.first,
        maxSelect = it.selectRange.last,
        onDeleteOptionGroupButtonClicked = onDeleteOptionGroupButtonClicked,
        onAddOptionButtonClicked = onAddOptionButtonClicked
    ).apply {
        optionUiStates = it.options.toOptionUiStates(
            optionGroupUiState = this,
            onDeleteOptionButtonClicked = onDeleteOptionButtonClicked
        )
    }
}

private fun List<Option>.toOptionUiStates(
    optionGroupUiState: OptionGroupUiState,
    onDeleteOptionButtonClicked: OptionUiState.() -> Unit
) = map {
    OptionUiState(
        id = it.id,
        name = it.name,
        additionalPrice = it.additionalPrice,
        optionGroupUiState = optionGroupUiState,
        onDeleteOptionButtonClicked = onDeleteOptionButtonClicked
    )
}

fun List<OptionGroupUiState>.toOptionGroups() = map {
    OptionGroup(
        id = it.id,
        name = it.name,
        options = it.optionUiStates.toOptions(),
        selectRange = it.minSelect..it.maxSelect
    )
}

private fun List<OptionUiState>.toOptions() = map {
    Option(
        id = it.id,
        name = it.name,
        additionalPrice = it.additionalPrice
    )
}