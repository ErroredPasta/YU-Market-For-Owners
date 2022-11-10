package com.example.yumarketforowners.presentation.screen.itemmanage

import com.example.yumarketforowners.domain.model.item.Item
import com.example.yumarketforowners.presentation.screen.base.BaseView
import com.example.yumarketforowners.presentation.viewholder.itemmanage.ItemUiState

interface ItemManageView : BaseView {
    fun onRequestDataSuccess(data: List<ItemUiState>)
    fun navigateToEditScreen(item: Item)
}