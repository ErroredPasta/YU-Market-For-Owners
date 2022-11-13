package com.example.yumarketforowners.domain.repository

import com.example.yumarketforowners.domain.model.review.Review

interface ReviewRepository {
    suspend fun getAllReviewsByMarketId(marketId: String): List<Review>
}