package com.example.yumarketforowners.presentation.screen.marketmanage.updatemarket

import com.example.yumarketforowners.domain.model.market.UpdateMarket
import com.example.yumarketforowners.domain.usecase.market.GetMarketDetailUseCase
import com.example.yumarketforowners.domain.usecase.market.UpdateMarketUseCase
import com.example.yumarketforowners.presentation.mapper.market.toUpdateMarket
import com.example.yumarketforowners.presentation.screen.base.BaseCoroutinePresenter
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Provider

class EditMarketPresenter(
    private val view: UpdateMarketView,
    private val getMarketDetailUseCase: GetMarketDetailUseCase,
    private val updateMarketUseCase: UpdateMarketUseCase,
    scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(scopeProvider) {

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        view.onError(throwable)
        throwable.printStackTrace()
    }

    fun requestMarketDetail(marketId: Long) {
        coroutineScope.launch(exceptionHandler) {
            view.loading(isLoading = true)
            val result = getMarketDetailUseCase(marketId = marketId).toUpdateMarket()
            view.loading(isLoading = false)

            view.onRequestMarketDetailSuccess(result)
        }
    }

    fun updateMarket(market: UpdateMarket) {
        coroutineScope.launch(exceptionHandler) {
            updateMarketUseCase(marketToUpdate = market)
            view.navigateBack()
        }
    }

    fun cancelEditMarket() {
        view.navigateBack()
    }
}
