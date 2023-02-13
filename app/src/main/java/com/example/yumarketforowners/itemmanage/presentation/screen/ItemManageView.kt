package com.example.yumarketforowners.itemmanage.presentation.screen

import com.example.yumarketforowners.itemmanage.domain.model.Item
import com.example.yumarketforowners.core.presentation.base.BaseView
import com.example.yumarketforowners.itemmanage.presentation.viewholder.ItemUiState

interface ItemManageView : BaseView {
    fun onRequestDataSuccess(data: List<ItemUiState>)
    fun navigateToEditScreen(item: Item)
}