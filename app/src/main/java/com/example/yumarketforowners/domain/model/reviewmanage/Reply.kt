package com.example.yumarketforowners.domain.model.reviewmanage

data class Reply(
    val replyWriter: String,
    val profileImageUrl: String,
    val content: String,
    val replyTime: Long
)
