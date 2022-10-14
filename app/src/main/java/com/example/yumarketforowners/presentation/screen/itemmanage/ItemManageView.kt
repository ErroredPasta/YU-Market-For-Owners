package com.example.yumarketforowners.presentation.screen.itemmanage

interface ItemManageView {
    fun loading(isLoading: Boolean)
    fun onRequestDataSuccess(data: List<ItemUiState>)
    fun onRequestDataError(errorMessage: Int)
}