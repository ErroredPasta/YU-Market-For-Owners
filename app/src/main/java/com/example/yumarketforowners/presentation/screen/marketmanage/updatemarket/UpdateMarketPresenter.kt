package com.example.yumarketforowners.presentation.screen.marketmanage.updatemarket

import com.example.yumarketforowners.domain.model.market.UpdateMarket
import com.example.yumarketforowners.domain.usecase.market.GetMarketDetailUseCase
import com.example.yumarketforowners.domain.usecase.market.UpdateMarketUseCase
import com.example.yumarketforowners.presentation.mapper.market.toDeliveryFee
import com.example.yumarketforowners.presentation.mapper.market.toDeliveryFeeUiState
import com.example.yumarketforowners.presentation.mapper.market.toUpdateMarket
import com.example.yumarketforowners.presentation.screen.base.BaseCoroutinePresenter
import com.example.yumarketforowners.presentation.viewholder.deliveryfee.DeliveryFeeUiState
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
