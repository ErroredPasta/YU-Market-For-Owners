package com.example.yumarketforowners.presentation.screen.marketmanage.updatemarket

import com.example.yumarketforowners.domain.model.market.UpdateMarket

interface UpdateMarketView {
    fun loading(isLoading: Boolean)
    fun onRequestMarketDetailSuccess(market: UpdateMarket)
    fun onError(throwable: Throwable)
    fun navigateBack()
}