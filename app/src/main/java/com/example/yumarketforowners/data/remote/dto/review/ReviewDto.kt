package com.example.yumarketforowners.data.remote.dto.review

// CR
// non-updatable entity
data class ReviewDto(
    var id: Long = 0L,
    var writerId: Long = 0L,
    var writtenAt: Long = 0L,
    var marketId: Long = 0L,
    var orderId: Long = 0L,
    var title: String? = null,
    var content: String = "",
    var rating: Int = 0,
    var reviewImages: List<String> = emptyList()
)
