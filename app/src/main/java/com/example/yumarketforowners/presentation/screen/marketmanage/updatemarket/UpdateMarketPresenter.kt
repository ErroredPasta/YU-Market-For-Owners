package com.example.yumarketforowners.presentation.screen.marketmanage.updatemarket

import com.example.yumarketforowners.domain.model.market.UpdateMarket
import com.example.yumarketforowners.domain.usecase.market.GetMarketDetailUseCase
import com.example.yumarketforowners.domain.usecase.market.UpdateMarketUseCase
import com.example.yumarketforowners.presentation.mapper.market.toUpdateMarket
import com.example.yumarketforowners.presentation.screen.base.BaseCoroutinePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Provider

class UpdateMarketPresenter(
    private val view: UpdateMarketView,
    private val getMarketDetailUseCase: GetMarketDetailUseCase,
    private val updateMarketUseCase: UpdateMarketUseCase,
    scopeProvider: Provider<CoroutineScope>,
) : BaseCoroutinePresenter(view, scopeProvider) {

    fun requestMarketDetail(marketId: String) {
        coroutineScope.launch {
            view.loading(isLoading = true)
            val result = getMarketDetailUseCase(marketId = marketId).toUpdateMarket()
            view.loading(isLoading = false)

            view.onRequestMarketDetailSuccess(result)
        }
    }

    fun updateMarket(market: UpdateMarket) {
        coroutineScope.launch {
            updateMarketUseCase(marketToUpdate = market)
            view.navigateBack()
        }
    }

    fun cancelUpdateMarket() {
        view.navigateBack()
    }

    fun addDeliveryFee() {
        TODO("Not yet implemented")
    }
}
