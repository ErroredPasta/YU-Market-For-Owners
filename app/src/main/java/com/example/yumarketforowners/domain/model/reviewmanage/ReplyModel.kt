package com.example.yumarketforowners.domain.model.reviewmanage

data class ReplyModel(
    val replyWriter: String,
    val profileImageUrl: String,
    val content: String,
    val replyTime: Long
)
