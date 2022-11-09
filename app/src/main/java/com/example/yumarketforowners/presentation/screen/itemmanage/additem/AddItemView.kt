package com.example.yumarketforowners.presentation.screen.itemmanage.additem

import com.example.yumarketforowners.presentation.screen.base.BaseView
import com.example.yumarketforowners.presentation.screen.itemmanage.updateitem.OptionGroupUiState

interface AddItemView : BaseView {
    fun navigateBack()
    fun showOptionGroups(optionGroups: List<OptionGroupUiState>)
}