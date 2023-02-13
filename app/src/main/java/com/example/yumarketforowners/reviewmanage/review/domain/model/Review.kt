package com.example.yumarketforowners.reviewmanage.review.domain.model

import com.example.yumarketforowners.orderlist.domain.model.Order

data class Review(
    val id: Long,
    val writerName: String,
    val profileImageUrl: String?,
    val writtenAt: Long,
    val order: Order,
    val title: String?,
    val content: String,
    val rating: Int,
    val reviewImages: List<String>,
    val reply: Reply? = null
)
