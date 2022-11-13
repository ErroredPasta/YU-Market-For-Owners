package com.example.yumarketforowners.data.remote.datasource.review

import com.example.yumarketforowners.data.remote.dto.review.ReviewDto

interface ReviewRemoteDataSource {
    suspend fun getAllReviewsByMarketId(marketId: String): List<ReviewDto>
}