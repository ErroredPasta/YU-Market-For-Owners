package com.example.yumarketforowners.presentation.screen.itemmanage

import com.example.yumarketforowners.domain.model.item.Item

interface ItemManageView {
    fun loading(isLoading: Boolean)
    fun onRequestDataSuccess(data: List<ItemUiState>)
    fun onRequestDataError(errorMessage: Int)
    fun navigateToEditScreen(item: Item)
}