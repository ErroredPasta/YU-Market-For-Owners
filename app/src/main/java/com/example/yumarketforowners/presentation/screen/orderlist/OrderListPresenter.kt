package com.example.yumarketforowners.presentation.screen.orderlist

import com.example.yumarketforowners.domain.repository.OrderListRepository
import com.example.yumarketforowners.presentation.screen.orderlist.OrderListContract.State
import javax.inject.Inject

class OrderListPresenter @Inject constructor(
    private val view: OrderListContract.View,
    private val repository: OrderListRepository
) : OrderListContract.Presenter {

    override fun requestData(marketId: Long) {
        view.loading(show = true)
        /* TODO: 2022-09-21 수 01:34, error 처리 구현 */
        val result: State = State.Success(
            data = repository.getOrderListByMarketId(marketId)
        )
        view.loading(show = false)

        if (result is State.Success) {
            view.onRequestDataSuccess(result.data)
        } else {
            view.onRequestDataError((result as State.Error).errorMessage)
        }
    }
}