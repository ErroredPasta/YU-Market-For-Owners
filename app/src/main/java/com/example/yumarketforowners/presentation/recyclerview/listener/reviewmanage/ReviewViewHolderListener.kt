package com.example.yumarketforowners.presentation.recyclerview.listener.reviewmanage

import com.example.yumarketforowners.presentation.recyclerview.listener.AdapterListener
import com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.review.ReviewUiState

interface ReviewViewHolderListener : AdapterListener{
    fun onReplyClicked(review: ReviewUiState)
}