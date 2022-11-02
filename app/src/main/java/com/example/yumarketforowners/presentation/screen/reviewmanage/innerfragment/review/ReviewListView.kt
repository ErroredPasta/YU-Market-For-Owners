package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.review

import com.example.yumarketforowners.presentation.screen.base.BaseView

interface ReviewListView : BaseView {
    fun onRequestDataSuccess(data: List<ReviewUiState>)
}