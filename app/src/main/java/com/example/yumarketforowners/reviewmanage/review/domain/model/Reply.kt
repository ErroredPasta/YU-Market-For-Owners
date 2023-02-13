package com.example.yumarketforowners.reviewmanage.review.domain.model

data class Reply(
    val id: Long,
    val writerName: String,
    val profileImageUrl: String? = null,
    val content: String,
    val writtenAt: Long
)
