package com.example.yumarketforowners.presentation.recyclerview.listener.reviewmanage

import com.example.yumarketforowners.presentation.recyclerview.listener.AdapterListener
import com.example.yumarketforowners.domain.model.reviewmanage.Review

interface ReviewViewHolderListener : AdapterListener{
    fun onReplyClicked(review: Review)
}