package com.example.yumarketforowners.presentation.mapper.item

import com.example.yumarketforowners.domain.model.item.Option
import com.example.yumarketforowners.domain.model.item.OptionGroup
import com.example.yumarketforowners.presentation.viewholder.itemmanage.OptionGroupUiState
import com.example.yumarketforowners.presentation.viewholder.itemmanage.OptionUiState

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