package com.example.yumarketforowners.data.mapper.review

import com.example.yumarketforowners.data.remote.dto.review.ReviewDto
import com.example.yumarketforowners.domain.model.order.Order
import com.example.yumarketforowners.domain.model.review.Reply
import com.example.yumarketforowners.domain.model.review.Review

fun ReviewDto.toReview(
    writerName: String,
    profileImageUrl: String? = null,
    order: Order,
    reply: Reply? = null
) = Review(
    id = id,
    writerName = writerName,
    profileImageUrl = profileImageUrl,
    writtenAt = writtenAt,
    order = order,
    title = title,
    content = content,
    rating = rating,
    reviewImages = reviewImages,
    reply = reply
)