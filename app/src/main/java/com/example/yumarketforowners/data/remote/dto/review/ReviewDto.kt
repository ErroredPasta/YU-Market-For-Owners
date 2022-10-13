package com.example.yumarketforowners.data.remote.dto.review

// CR
// non-updatable entity
data class ReviewDto(
    val id: Long,
    val writerId: Long,
    val writtenAt: Long,
    val marketId: Long,
    val orderId: Long,
    val title: String? = null,
    val content: String,
    val rating: Int,
    val reviewImages: List<String>
)
