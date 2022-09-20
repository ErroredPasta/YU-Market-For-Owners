package com.example.yumarketforowners.presentation.recyclerview.viewholder.orderlist

import com.example.yumarketforowners.presentation.recyclerview.viewholder.BaseViewHolder
import com.example.yumarketforowners.domain.model.itemmanage.Item
import com.example.yumarketforowners.databinding.ViewHolderOrderItemBinding
import com.example.yumarketforowners.presentation.extension.clear

class OrderItemViewHolder(
    binding: ViewHolderOrderItemBinding
) : BaseViewHolder<ViewHolderOrderItemBinding, Item>(binding) {
    override fun clear() {
        binding.orderItemImageView.clear()
    }

    override fun bindData(model: Item) {
        super.bindData(model)
        binding.itemModel = model
    }
}