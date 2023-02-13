package com.example.yumarketforowners.reviewmanage.review.data.datasource

import com.example.yumarketforowners.reviewmanage.review.data.dto.ReviewDto

interface ReviewRemoteDataSource {
    suspend fun getAllReviewsByMarketId(marketId: String): List<ReviewDto>
}