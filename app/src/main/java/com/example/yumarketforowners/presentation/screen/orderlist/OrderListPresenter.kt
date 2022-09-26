package com.example.yumarketforowners.presentation.screen.orderlist

import com.example.yumarketforowners.R
import com.example.yumarketforowners.domain.model.orderlist.Order
import com.example.yumarketforowners.domain.model.orderlist.OrderState
import com.example.yumarketforowners.domain.usecase.order.GetOrderList
import com.example.yumarketforowners.presentation.screen.base.State
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class OrderListPresenter @Inject constructor(
    private val view: OrderListInnerFragment,
    private val getOrderList: GetOrderList,
    private val scopeProvider: Provider<CoroutineScope>
) {
    private val coroutineScope get() = scopeProvider.get()

    fun requestData(marketId: Long, orderState: OrderState) {
        coroutineScope.launch {
            view.loading(show = true)
            /* TODO: 2022-09-21 수 01:34, error 처리 구현 */
            val result = getOrderList(marketId = marketId, orderState = orderState)?.let {
                State.Success(
                    data = it
                )
            } ?: State.Error(R.string.error_placeholder)

            view.loading(show = false)

            @Suppress("UNCHECKED_CAST")
            when (result) {
                is State.Success<*> -> view.onRequestDataSuccess(result.data as List<Order>)
                is State.Error -> view.onRequestDataError(result.errorMessage)
            }
        }
    }

}