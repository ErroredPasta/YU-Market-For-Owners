package com.example.yumarketforowners.presentation.screen.orderlist

import androidx.annotation.StringRes
import com.example.yumarketforowners.domain.model.orderlist.OrderModel

interface OrderListContract {
    interface View {
        fun loading(show: Boolean)
        fun onRequestDataSuccess(data: List<OrderModel>)
        fun onRequestDataError(@StringRes errorMessage: Int)
    }

    interface Presenter {
        fun requestData(marketId: Long)
    }

    sealed class State {
        data class Success(
            val data: List<OrderModel>
        ) : State()

        data class Error(
            @StringRes val errorMessage: Int
        ) : State()
    }
}