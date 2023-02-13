package com.example.yumarketforowners.itemmanage.presentation.screen.additem

import com.example.yumarketforowners.core.presentation.base.BaseView
import com.example.yumarketforowners.itemmanage.presentation.viewholder.OptionGroupUiState

interface AddItemView : BaseView {
    fun navigateBack()
    fun showOptionGroups(optionGroups: List<OptionGroupUiState>)
}