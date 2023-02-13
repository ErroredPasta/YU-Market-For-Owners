package com.example.yumarketforowners.reviewmanage.review.domain.repository

import com.example.yumarketforowners.reviewmanage.review.domain.model.Review

interface ReviewRepository {
    suspend fun getAllReviewsByMarketId(marketId: String): List<Review>
}