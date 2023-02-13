package com.example.yumarketforowners.marketmanage.market.presentation.screen.updatemarket

import com.example.yumarketforowners.marketmanage.market.domain.model.UpdateMarket
import com.example.yumarketforowners.core.presentation.base.BaseView
import com.example.yumarketforowners.marketmanage.market.presentation.viewholder.DeliveryFeeUiState

interface UpdateMarketView : BaseView {
    fun onRequestMarketDetailSuccess(market: UpdateMarket)
    fun showDeliveryFees(deliveryFees: List<DeliveryFeeUiState>)
    fun navigateBack()
}