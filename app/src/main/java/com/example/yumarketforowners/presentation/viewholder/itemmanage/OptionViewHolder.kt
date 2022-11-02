package com.example.yumarketforowners.presentation.viewholder.itemmanage

import com.example.yumarketforowners.databinding.ViewHolderOptionBinding
import com.example.yumarketforowners.presentation.screen.itemmanage.updateitem.OptionUiState
import com.example.yumarketforowners.presentation.viewholder.BaseViewHolder

class OptionViewHolder(
    binding: ViewHolderOptionBinding
) : BaseViewHolder<ViewHolderOptionBinding, OptionUiState>(binding) {

    override fun bindData(model: OptionUiState) = with(binding) {
        super.bindData(model)
        optionUiState = model
    }
}