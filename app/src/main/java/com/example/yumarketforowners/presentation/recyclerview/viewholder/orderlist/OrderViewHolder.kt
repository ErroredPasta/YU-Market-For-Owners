package com.example.yumarketforowners.presentation.recyclerview.viewholder.orderlist

import com.example.yumarketforowners.databinding.ViewHolderOrderBinding
import com.example.yumarketforowners.domain.model.item.Item
import com.example.yumarketforowners.domain.model.order.Order
import com.example.yumarketforowners.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.presentation.recyclerview.listener.AdapterListener
import com.example.yumarketforowners.presentation.recyclerview.listener.orderlist.OrderViewHolderListener
import com.example.yumarketforowners.presentation.recyclerview.viewholder.BaseViewHolder
import com.example.yumarketforowners.presentation.screen.orderlist.OrderItemUiState
import com.example.yumarketforowners.presentation.screen.orderlist.OrderUiState

class OrderViewHolder(
    binding: ViewHolderOrderBinding
) : BaseViewHolder<ViewHolderOrderBinding, OrderUiState>(binding) {

    override fun bindData(model: OrderUiState) {
        super.bindData(model)
        binding.orderUiState = model
        binding.orderItemRecyclerView.adapter = ModelRecyclerAdapter<OrderItemUiState>().also {
            it.submitList(model.orderItems)
        }
    }

    override fun bindListener(listener: AdapterListener) {
        if (listener is OrderViewHolderListener) {
            binding.listener = listener
        }
    }
}