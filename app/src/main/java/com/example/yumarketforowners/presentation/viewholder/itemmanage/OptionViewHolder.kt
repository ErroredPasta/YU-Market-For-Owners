package com.example.yumarketforowners.presentation.viewholder.itemmanage

import com.example.yumarketforowners.databinding.ViewHolderOptionBinding
import com.example.yumarketforowners.presentation.screen.base.BaseViewHolderState
import com.example.yumarketforowners.presentation.viewholder.BaseViewHolder
import com.example.yumarketforowners.presentation.viewholder.CellType

class OptionViewHolder(
    binding: ViewHolderOptionBinding
) : BaseViewHolder<ViewHolderOptionBinding, OptionUiState>(binding) {

    override fun bindData(model: OptionUiState) = with(binding) {
        super.bindData(model)
        optionUiState = model
    }
}

data class OptionUiState(
    override val id: Long,
    var name: String = "",
    var additionalPrice: Int,
    val optionGroupUiState: OptionGroupUiState,
    val onDeleteOptionButtonClicked: OptionUiState.() -> Unit,
) : BaseViewHolderState(id, CellType.OPTION_CELL)