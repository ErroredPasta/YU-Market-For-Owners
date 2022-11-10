package com.example.yumarketforowners.presentation.viewholder.deliveryfee

import com.example.yumarketforowners.databinding.ViewHolderDeliveryFeeBinding
import com.example.yumarketforowners.presentation.screen.base.BaseViewHolderState
import com.example.yumarketforowners.presentation.viewholder.BaseViewHolder
import com.example.yumarketforowners.presentation.viewholder.CellType

class DeliveryFeeViewHolder(
    binding: ViewHolderDeliveryFeeBinding
) : BaseViewHolder<ViewHolderDeliveryFeeBinding, DeliveryFeeUiState>(binding) {

    override fun bindData(model: DeliveryFeeUiState) {
        super.bindData(model)
        binding.deliveryFeeUiState = model
    }
}

data class DeliveryFeeUiState(
    override val id: Long,
    var startPrice: Int = 0,
    var endPrice: Int = 0,
    var deliveryFee: Int = 0,
    val onDeleteButtonClicked: () -> Unit
) : BaseViewHolderState(id, CellType.DELIVERY_FEE_CELL)