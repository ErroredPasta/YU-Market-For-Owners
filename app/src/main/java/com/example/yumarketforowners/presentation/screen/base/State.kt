package com.example.yumarketforowners.presentation.screen.base

import androidx.annotation.StringRes

sealed interface State {
    data class Success<T>(
        val data: T
    ) : State

    data class Error(
        @StringRes val errorMessage: Int
    ) : State
}