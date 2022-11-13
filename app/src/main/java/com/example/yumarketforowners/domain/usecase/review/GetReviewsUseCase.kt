package com.example.yumarketforowners.domain.usecase.review

import com.example.yumarketforowners.domain.repository.ReviewRepository

class GetReviewsUseCase(
    private val repository: ReviewRepository
) {
    suspend operator fun invoke(marketId: String) = repository.getAllReviewsByMarketId(marketId)
}