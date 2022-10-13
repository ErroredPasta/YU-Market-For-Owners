package com.example.yumarketforowners.presentation.recyclerview.viewholder.orderlist

import com.example.yumarketforowners.databinding.ViewHolderOrderItemBinding
import com.example.yumarketforowners.presentation.extension.clear
import com.example.yumarketforowners.presentation.recyclerview.viewholder.BaseViewHolder
import com.example.yumarketforowners.presentation.screen.orderlist.OrderItemUiState

class OrderItemViewHolder(
    binding: ViewHolderOrderItemBinding
) : BaseViewHolder<ViewHolderOrderItemBinding, OrderItemUiState>(binding) {
    override fun clear() {
        binding.orderItemImageView.clear()
    }

    override fun bindData(model: OrderItemUiState) {
        super.bindData(model)
        binding.orderItemUiState = model
    }
}