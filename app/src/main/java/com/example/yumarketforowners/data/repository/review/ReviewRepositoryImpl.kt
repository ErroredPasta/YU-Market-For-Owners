package com.example.yumarketforowners.data.repository.review

import com.example.yumarketforowners.data.remote.review.ReviewRemoteDataSource
import com.example.yumarketforowners.domain.repository.ReviewRepository
import javax.inject.Inject

class ReviewRepositoryImpl @Inject constructor(
    private val remoteDataSource: ReviewRemoteDataSource
) : ReviewRepository {

    override suspend fun getAllReviewsByMarketId(marketId: Long) =
        remoteDataSource.getAllReviewsByMarketId(marketId)
}