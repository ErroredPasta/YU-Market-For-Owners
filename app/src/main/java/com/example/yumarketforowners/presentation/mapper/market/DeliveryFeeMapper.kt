package com.example.yumarketforowners.presentation.mapper.market

import com.example.yumarketforowners.domain.model.market.DeliveryFee
import com.example.yumarketforowners.presentation.viewholder.deliveryfee.DeliveryFeeUiState

fun DeliveryFee.toDeliveryFeeUiState(
    onDeleteButtonClicked: () -> Unit
) = DeliveryFeeUiState(
    id = id,
    startPrice = priceRange.first,
    endPrice = priceRange.last + 1,
    deliveryFee = fee,
    onDeleteButtonClicked = onDeleteButtonClicked
)

fun DeliveryFeeUiState.toDeliveryFee() = DeliveryFee(
    id = id,
    priceRange = startPrice until endPrice,
    fee = deliveryFee
)