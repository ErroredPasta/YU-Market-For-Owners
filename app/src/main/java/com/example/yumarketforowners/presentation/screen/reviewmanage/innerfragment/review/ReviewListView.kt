package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.review

import com.example.yumarketforowners.presentation.screen.base.BaseView
import com.example.yumarketforowners.presentation.viewholder.reviewmanage.ReviewUiState

interface ReviewListView : BaseView {
    fun onRequestDataSuccess(data: List<ReviewUiState>)
}