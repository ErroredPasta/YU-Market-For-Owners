package com.example.yumarketforowners.reviewmanage.review.data.repository

import com.example.yumarketforowners.data.mapper.review.toReview
import com.example.yumarketforowners.reviewmanage.review.data.datasource.ReviewRemoteDataSource
import com.example.yumarketforowners.reviewmanage.review.domain.model.Review
import com.example.yumarketforowners.orderlist.domain.repository.OrderRepository
import com.example.yumarketforowners.reviewmanage.review.domain.repository.ReviewRepository
import javax.inject.Inject

class ReviewRepositoryImpl @Inject constructor(
    private val remoteDataSource: ReviewRemoteDataSource,
    private val orderRepository: OrderRepository
) : ReviewRepository {

    override suspend fun getAllReviewsByMarketId(marketId: String): List<Review> =
        remoteDataSource.getAllReviewsByMarketId(marketId).map {
            it.toReview(
                writerName = "writerName ${it.id}",
                profileImageUrl = "https://picsum.photos/200",
                order = orderRepository.getOrderById(it.orderId)!!,
                reply = null /* TODO: 2022-10-13 목 12:45, 제대로 reply 찾아서 반영하기 */
            )
        }
}