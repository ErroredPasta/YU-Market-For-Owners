package com.example.yumarketforowners.presentation.screen.marketmanage.updatemarket

import com.example.yumarketforowners.domain.model.market.UpdateMarket
import com.example.yumarketforowners.presentation.screen.base.BaseView

interface UpdateMarketView : BaseView {
    fun onRequestMarketDetailSuccess(market: UpdateMarket)
    fun navigateBack()
}