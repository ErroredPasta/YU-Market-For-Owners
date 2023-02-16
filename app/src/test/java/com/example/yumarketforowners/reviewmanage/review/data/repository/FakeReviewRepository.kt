package com.example.yumarketforowners.reviewmanage.review.data.repository

import com.example.yumarketforowners.reviewmanage.review.domain.model.Review
import com.example.yumarketforowners.reviewmanage.review.domain.repository.ReviewRepository
import com.example.yumarketforowners.entity.createReview

class FakeReviewRepository : ReviewRepository {
    private val reviews = (1..10).map {
        createReview(it)
    }.toMutableList()

    override suspend fun getAllReviewsByMarketId(marketId: String): List<Review> = reviews
}

fun Review.shouldHaveReply() = id.toInt() % 2 == 0