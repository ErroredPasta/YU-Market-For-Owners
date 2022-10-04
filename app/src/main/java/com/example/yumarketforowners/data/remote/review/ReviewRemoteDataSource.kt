package com.example.yumarketforowners.data.remote.review

import com.example.yumarketforowners.domain.model.reviewmanage.Review

interface ReviewRemoteDataSource {
    suspend fun getAllReviewsByMarketId(marketId: Long): List<Review>
}