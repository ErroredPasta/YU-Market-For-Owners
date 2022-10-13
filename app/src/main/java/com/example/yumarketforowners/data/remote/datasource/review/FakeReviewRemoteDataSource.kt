package com.example.yumarketforowners.data.remote.datasource.review

import com.example.yumarketforowners.data.remote.dto.review.ReviewDto
import javax.inject.Inject

class FakeReviewRemoteDataSource @Inject constructor() : ReviewRemoteDataSource {

    private val testList = (0..9).map {
        ReviewDto(
            id = it.toLong(),
            writerId = it.toLong(),
            writtenAt = it.toLong(),
            marketId = it.toLong(),
            orderId = it.toLong(),
            title = "title $it",
            content = "content $it",
            rating = it,
            reviewImages = listOf(
                "https://picsum.photos/200",
                "https://picsum.photos/200",
                "https://picsum.photos/200"
            )
        )
    }

    override suspend fun getAllReviewsByMarketId(marketId: Long) = testList
}