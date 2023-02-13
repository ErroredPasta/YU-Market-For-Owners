package com.example.yumarketforowners.itemmanage.presentation.screen.updateitem

import com.example.yumarketforowners.core.presentation.base.BaseView
import com.example.yumarketforowners.itemmanage.presentation.viewholder.OptionGroupUiState

interface UpdateItemView : BaseView {
    fun onRequestItemSuccess(item: UpdateItemUiState)
    fun navigateBack()
    fun showOptionGroups(optionGroups: List<OptionGroupUiState>)
}