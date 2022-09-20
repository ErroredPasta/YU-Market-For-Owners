package com.example.yumarketforowners.presentation.recyclerview.viewholder.orderlist

import com.example.yumarketforowners.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.presentation.recyclerview.listener.AdapterListener
import com.example.yumarketforowners.presentation.recyclerview.listener.orderlist.OrderViewHolderListener
import com.example.yumarketforowners.presentation.recyclerview.viewholder.BaseViewHolder
import com.example.yumarketforowners.domain.model.itemmanage.Item
import com.example.yumarketforowners.domain.model.orderlist.Order
import com.example.yumarketforowners.databinding.ViewHolderOrderBinding

class OrderViewHolder(
    binding: ViewHolderOrderBinding
) : BaseViewHolder<ViewHolderOrderBinding, Order>(binding) {

    override fun bindData(model: Order) {
        super.bindData(model)
        binding.orderModel = model
        binding.orderItemRecyclerView.adapter = ModelRecyclerAdapter<Item>(
            model.orderItems
        )
    }

    override fun bindListener(listener: AdapterListener) {
        if (listener is OrderViewHolderListener) {
            binding.listener = listener
        }
    }
}