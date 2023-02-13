package com.example.yumarketforowners.marketmanage.market.presentation.mapper

import com.example.yumarketforowners.marketmanage.market.domain.model.DeliveryFee
import com.example.yumarketforowners.marketmanage.market.presentation.viewholder.DeliveryFeeUiState

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