package com.example.yumarketforowners.domain.model.review

import com.example.yumarketforowners.domain.model.order.Order

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
