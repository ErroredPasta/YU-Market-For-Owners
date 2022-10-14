package com.example.yumarketforowners.presentation.mapper.review

import com.example.yumarketforowners.domain.model.review.Review
import com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.review.ReviewUiState

fun Review.toReviewUiState(
    onReplyClicked: () -> Unit
) = ReviewUiState(
    id = id,
    writerName = writerName,
    profileImageUrl = profileImageUrl,
    writtenAt = writtenAt,
    order = order,
    title = title,
    content = content,
    rating = rating,
    reviewImages = reviewImages,
    reply = reply,
    onReplyClicked = onReplyClicked
)

fun ReviewUiState.toReview() = Review(
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