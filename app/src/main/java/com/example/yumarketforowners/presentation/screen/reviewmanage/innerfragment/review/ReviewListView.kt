package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.review

import androidx.annotation.StringRes

interface ReviewListView {
    fun loading(isLoading: Boolean)
    fun onRequestDataSuccess(data: List<ReviewUiState>)
    fun onRequestDataError(@StringRes errorMessage: Int)
}