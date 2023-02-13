package com.example.yumarketforowners.marketmanage.market.presentation.viewholder

import com.example.yumarketforowners.databinding.ViewHolderDeliveryFeeBinding
import com.example.yumarketforowners.core.presentation.base.BaseViewHolderState
import com.example.yumarketforowners.core.presentation.viewholder.BaseViewHolder
import com.example.yumarketforowners.core.presentation.viewholder.CellType

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