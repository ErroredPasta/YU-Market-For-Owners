package com.example.yumarketforowners.presentation.screen.marketmanage.updatemarket

import com.example.yumarketforowners.domain.model.market.UpdateMarket
import com.example.yumarketforowners.presentation.screen.base.BaseView
import com.example.yumarketforowners.presentation.viewholder.deliveryfee.DeliveryFeeUiState

interface UpdateMarketView : BaseView {
    fun onRequestMarketDetailSuccess(market: UpdateMarket)
    fun showDeliveryFees(deliveryFees: List<DeliveryFeeUiState>)
    fun navigateBack()
}