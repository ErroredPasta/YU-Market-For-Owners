package com.example.yumarketforowners.reviewmanage.review.domain.usecase

import com.example.yumarketforowners.reviewmanage.review.domain.repository.ReviewRepository

class GetReviewsUseCase(
    private val repository: ReviewRepository
) {
    suspend operator fun invoke(marketId: String) = repository.getAllReviewsByMarketId(marketId)
}