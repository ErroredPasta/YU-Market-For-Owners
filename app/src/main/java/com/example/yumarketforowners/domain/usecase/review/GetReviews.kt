package com.example.yumarketforowners.domain.usecase.review

import com.example.yumarketforowners.domain.repository.ReviewRepository

class GetReviews(
    private val repository: ReviewRepository
) {
    suspend operator fun invoke(marketId: Long) = repository.getAllReviewsByMarketId(marketId)
}