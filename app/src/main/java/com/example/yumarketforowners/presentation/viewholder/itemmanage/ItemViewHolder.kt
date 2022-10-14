package com.example.yumarketforowners.presentation.viewholder.itemmanage

import com.example.yumarketforowners.databinding.ViewHolderItemBinding
import com.example.yumarketforowners.presentation.viewholder.BaseViewHolder
import com.example.yumarketforowners.presentation.screen.itemmanage.ItemUiState

class ItemViewHolder(
    binding: ViewHolderItemBinding
) : BaseViewHolder<ViewHolderItemBinding, ItemUiState>(binding) {
    override fun clear() {
        // TODO: 2022.05.30 clear image view
    }

    override fun bindData(model: ItemUiState) {
        super.bindData(model)
        binding.itemUiState = model
    }
}