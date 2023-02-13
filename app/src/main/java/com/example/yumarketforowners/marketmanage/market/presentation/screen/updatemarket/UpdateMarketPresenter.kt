package com.example.yumarketforowners.marketmanage.market.presentation.screen.updatemarket

import com.example.yumarketforowners.marketmanage.market.domain.model.UpdateMarket
import com.example.yumarketforowners.marketmanage.market.domain.usecase.GetMarketDetailUseCase
import com.example.yumarketforowners.marketmanage.market.domain.usecase.UpdateMarketUseCase
import com.example.yumarketforowners.marketmanage.market.presentation.mapper.toDeliveryFee
import com.example.yumarketforowners.marketmanage.market.presentation.mapper.toDeliveryFeeUiState
import com.example.yumarketforowners.marketmanage.market.presentation.mapper.toUpdateMarket
import com.example.yumarketforowners.core.presentation.base.BaseCoroutinePresenter
import com.example.yumarketforowners.marketmanage.market.presentation.viewholder.DeliveryFeeUiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Provider

class UpdateMarketPresenter(
    private val view: UpdateMarketView,
    private val getMarketDetailUseCase: GetMarketDetailUseCase,
    private val updateMarketUseCase: UpdateMarketUseCase,
    scopeProvider: Provider<CoroutineScope>,
) : BaseCoroutinePresenter(view, scopeProvider) {

    private lateinit var deliveryFeeUiStates: List<DeliveryFeeUiState>

    fun requestMarketDetail(marketId: String) {
        coroutineScope.launch {
            view.loading(isLoading = true)
            val result = getMarketDetailUseCase(marketId = marketId).toUpdateMarket().also {
                deliveryFeeUiStates = it.deliveryFees.map { deliveryFee ->
                    deliveryFee.toDeliveryFeeUiState(
                        onDeleteButtonClicked = {
                            deleteDeliveryFee(deliveryFeeId = deliveryFee.id)
                        }
                    )
                }
            }
            view.loading(isLoading = false)

            view.onRequestMarketDetailSuccess(result)
            view.showDeliveryFees(deliveryFees = deliveryFeeUiStates)
        }
    }

    fun updateMarket(market: UpdateMarket) {
        coroutineScope.launch {
            updateMarketUseCase(
                marketToUpdate = market.copy(
                    deliveryFees = deliveryFeeUiStates.map { it.toDeliveryFee() }
                )
            )
            view.navigateBack()
        }
    }

    fun cancelUpdateMarket() {
        view.navigateBack()
    }

    fun addDeliveryFee() {
        deliveryFeeUiStates = deliveryFeeUiStates + createDeliveryFeeUiState()
        view.showDeliveryFees(deliveryFees = deliveryFeeUiStates)
    }

    private fun deleteDeliveryFee(deliveryFeeId: Long) {
        deliveryFeeUiStates =
            deliveryFeeUiStates - deliveryFeeUiStates.find { it.id == deliveryFeeId }!!

        view.showDeliveryFees(deliveryFeeUiStates)
    }

    private fun createDeliveryFeeUiState(): DeliveryFeeUiState {
        val id = -(deliveryFeeUiStates.size + 1L)
        val lastDeliveryFeeStart = if (deliveryFeeUiStates.isEmpty()) {
            0
        } else {
            deliveryFeeUiStates.last().startPrice
        }

        return DeliveryFeeUiState(
            id = id,
            startPrice = lastDeliveryFeeStart,
            onDeleteButtonClicked = {
                deleteDeliveryFee(deliveryFeeId = id)
            }
        )
    }
}
