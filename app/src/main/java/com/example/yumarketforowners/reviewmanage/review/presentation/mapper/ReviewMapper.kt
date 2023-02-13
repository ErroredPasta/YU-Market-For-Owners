package com.example.yumarketforowners.reviewmanage.review.presentation.mapper

import com.example.yumarketforowners.reviewmanage.review.domain.model.Review
import com.example.yumarketforowners.reviewmanage.review.presentation.viewholder.ReviewUiState

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