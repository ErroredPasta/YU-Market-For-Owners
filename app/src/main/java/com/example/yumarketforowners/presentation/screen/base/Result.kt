package com.example.yumarketforowners.presentation.screen.base

import androidx.annotation.StringRes

sealed interface Result<T> {
    data class Success<T>(
        val data: T
    ) : Result<T>

    data class Error(
        @StringRes val errorMessage: Int
    ) : Result<Nothing>
}