package com.example.yumarketforowners.presentation.recyclerview.listener.itemmanage

import com.example.yumarketforowners.presentation.recyclerview.listener.AdapterListener
import com.example.yumarketforowners.presentation.screen.itemmanage.ItemUiState

interface ItemManageViewHolderListener : AdapterListener {
    // TODO: 2022.05.30 declare proper on click callbacks
    fun onEditItemButtonClick(item: ItemUiState)
}