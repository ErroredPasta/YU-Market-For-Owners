package com.example.yumarketforowners.presentation.recyclerview.listener.reviewmanage

import com.example.yumarketforowners.presentation.recyclerview.listener.AdapterListener
import com.example.yumarketforowners.domain.model.reviewmanage.ReviewModel

interface ReviewViewHolderListener : AdapterListener{
    fun onReplyClicked(review: ReviewModel)
}