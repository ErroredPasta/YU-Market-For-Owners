package com.example.yumarketforowners.data.mapper.review

import com.example.yumarketforowners.reviewmanage.review.data.dto.ReviewDto
import com.example.yumarketforowners.orderlist.domain.model.Order
import com.example.yumarketforowners.reviewmanage.review.domain.model.Reply
import com.example.yumarketforowners.reviewmanage.review.domain.model.Review

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