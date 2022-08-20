package com.example.yumarketforowners.presentation.recyclerview.viewholder.orderlist

import com.example.yumarketforowners.presentation.recyclerview.viewholder.BaseViewHolder
import com.example.yumarketforowners.domain.model.itemmanage.ItemModel
import com.example.yumarketforowners.databinding.ViewHolderOrderItemBinding
import com.example.yumarketforowners.extension.clear

class OrderItemViewHolder(
    binding: ViewHolderOrderItemBinding
) : BaseViewHolder<ViewHolderOrderItemBinding, ItemModel>(binding) {
    override fun clear() {
        binding.orderItemImageView.clear()
    }

    override fun bindData(model: ItemModel) {
        super.bindData(model)
        binding.itemModel = model
    }
}