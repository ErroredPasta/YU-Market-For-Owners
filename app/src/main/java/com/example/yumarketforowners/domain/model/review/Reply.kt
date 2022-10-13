package com.example.yumarketforowners.domain.model.review

data class Reply(
    val id: Long,
    val writerName: String,
    val profileImageUrl: String? = null,
    val content: String,
    val writtenAt: Long
)
