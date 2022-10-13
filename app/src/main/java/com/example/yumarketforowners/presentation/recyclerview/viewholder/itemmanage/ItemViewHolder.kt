package com.example.yumarketforowners.presentation.recyclerview.viewholder.itemmanage

import com.example.yumarketforowners.databinding.ViewHolderItemBinding
import com.example.yumarketforowners.domain.model.item.Item
import com.example.yumarketforowners.presentation.recyclerview.listener.AdapterListener
import com.example.yumarketforowners.presentation.recyclerview.listener.itemmanage.ItemManageViewHolderListener
import com.example.yumarketforowners.presentation.recyclerview.viewholder.BaseViewHolder
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

    override fun bindListener(listener: AdapterListener) {
        if (listener is ItemManageViewHolderListener) {
            binding.listener = listener
        }
    }
}