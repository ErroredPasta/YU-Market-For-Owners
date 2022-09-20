package com.example.yumarketforowners.presentation.screen.itemmanage

import androidx.annotation.StringRes
import com.example.yumarketforowners.domain.model.itemmanage.Item

interface ItemManageContract {
    interface View {
        fun loading(show: Boolean)
        fun onRequestDataSuccess(items: List<Item>)
        fun onRequestDataError(@StringRes errorMessage: Int)
    }

    interface Presenter {
        fun requestData(marketId: Long)
    }

    sealed class State {
        data class Success(
            val items: List<Item>
        ) : State()

        data class Error(
            @StringRes val errorMessage: Int
        ) : State()
    }
}