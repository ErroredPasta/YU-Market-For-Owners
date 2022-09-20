package com.example.yumarketforowners.presentation.screen.orderlist

import androidx.lifecycle.LifecycleCoroutineScope
import com.example.yumarketforowners.domain.model.orderlist.Order
import com.example.yumarketforowners.domain.repository.OrderRepository
import com.example.yumarketforowners.presentation.screen.base.State
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class OrderListPresenter @Inject constructor(
    private val view: OrderListInnerFragment,
    private val repository: OrderRepository,
    private val scopeProvider: Provider<LifecycleCoroutineScope>
) {
    private val coroutineScope get() = scopeProvider.get()

    fun requestData(marketId: Long) {
        coroutineScope.launch {
            view.loading(show = true)
            /* TODO: 2022-09-21 수 01:34, error 처리 구현 */
            val result: State = State.Success(
                data = repository.getOrderListByMarketId(marketId)
            )

            view.loading(show = false)

            @Suppress("UNCHECKED_CAST")
            when (result) {
                is State.Success<*> -> view.onRequestDataSuccess(result.data as List<Order>)
                is State.Error -> view.onRequestDataError(result.errorMessage)
            }
        }

    }
}