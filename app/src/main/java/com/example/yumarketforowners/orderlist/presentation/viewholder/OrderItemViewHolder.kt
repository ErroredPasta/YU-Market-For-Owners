package com.example.yumarketforowners.orderlist.presentation.viewholder

import com.example.yumarketforowners.databinding.ViewHolderOrderItemBinding
import com.example.yumarketforowners.orderlist.domain.model.OrderOptionGroup
import com.example.yumarketforowners.core.presentation.extension.clear
import com.example.yumarketforowners.core.presentation.base.BaseViewHolderState
import com.example.yumarketforowners.core.presentation.viewholder.BaseViewHolder
import com.example.yumarketforowners.core.presentation.viewholder.CellType

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

data class OrderItemUiState(
    override val id: Long,
    val name: String,
    val imageUrl: String?,
    val amount: Int,
    val pricePerItem: Int,
    val orderOptionGroups: List<OrderOptionGroup>
) : BaseViewHolderState(id, CellType.ORDER_ITEM_CELL)