package com.example.yumarketforowners.presentation.recyclerview.viewholder.itemmanage

import com.example.yumarketforowners.presentation.recyclerview.listener.AdapterListener
import com.example.yumarketforowners.presentation.recyclerview.listener.itemmanage.ItemManageViewHolderListener
import com.example.yumarketforowners.presentation.recyclerview.viewholder.BaseViewHolder
import com.example.yumarketforowners.domain.model.itemmanage.Item
import com.example.yumarketforowners.databinding.ViewHolderItemBinding

class ItemViewHolder(
    binding: ViewHolderItemBinding
) : BaseViewHolder<ViewHolderItemBinding, Item>(binding) {
    override fun clear() {
        // TODO: 2022.05.30 clear image view
    }

    override fun bindData(model: Item) {
        super.bindData(model)
        binding.itemModel = model
    }

    override fun bindListener(listener: AdapterListener) {
        if (listener is ItemManageViewHolderListener) {
            binding.listener = listener
        }
    }
}