package com.example.yumarketforowners.orderlist.presentation.viewholder

import com.example.yumarketforowners.databinding.ViewHolderOrderBinding
import com.example.yumarketforowners.orderlist.domain.model.DeliveryType
import com.example.yumarketforowners.orderlist.domain.model.OrderState
import com.example.yumarketforowners.core.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.core.presentation.base.BaseViewHolderState
import com.example.yumarketforowners.core.presentation.viewholder.BaseViewHolder
import com.example.yumarketforowners.core.presentation.viewholder.CellType
import java.time.LocalTime

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
}

data class OrderUiState(
    override val id: Long,
    val orderId: String,
    val orderedAt: Long,
    val orderItems: List<OrderItemUiState>,
    val totalPrice: Int,
    val orderState: OrderState,
    val deliveryFee: Int,
    val deliveryTime: Pair<LocalTime, LocalTime>,
    val deliveryType: DeliveryType,
    val telephoneNumber: String,
    val request: String,
    val onTelephoneNumberClicked: () -> Unit,
    val onAcceptOrderButtonClicked: () -> Unit,
    val onRejectOrderButtonClicked: () -> Unit,
    val onDeliveryDoneButtonClicked: () -> Unit
) : BaseViewHolderState(id, CellType.ORDER_CELL)