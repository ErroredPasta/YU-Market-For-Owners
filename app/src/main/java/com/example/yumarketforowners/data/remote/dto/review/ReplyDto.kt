package com.example.yumarketforowners.data.remote.dto.review

// CR
// non-updatable entity
data class ReplyDto(
    val id: Long,
    val reviewId: Long,
    val writerId: Long,
    val content: String,
    val writtenAt: Long
)
