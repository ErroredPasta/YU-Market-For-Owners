package com.example.yumarketforowners.data.repository

import com.example.yumarketforowners.domain.model.review.Review
import com.example.yumarketforowners.domain.repository.ReviewRepository
import com.example.yumarketforowners.entity.createReview

class FakeReviewRepository : ReviewRepository {
    private val reviews = (1..10).map {
        createReview(it)
    }.toMutableList()

    override suspend fun getAllReviewsByMarketId(marketId: String): List<Review> = reviews
}

fun Review.shouldHaveReply() = id.toInt() % 2 == 0