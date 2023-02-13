package com.example.yumarketforowners.reviewmanage.review.presentation.screen

import com.example.yumarketforowners.core.presentation.base.BaseView
import com.example.yumarketforowners.reviewmanage.review.presentation.viewholder.ReviewUiState

interface ReviewListView : BaseView {
    fun onRequestDataSuccess(data: List<ReviewUiState>)
}