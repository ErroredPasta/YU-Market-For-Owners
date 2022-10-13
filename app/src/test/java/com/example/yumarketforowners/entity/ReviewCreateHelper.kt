package com.example.yumarketforowners.entity

import com.example.yumarketforowners.domain.model.review.Reply
import com.example.yumarketforowners.domain.model.review.Review

fun createReview(it: Int) = Review(
    id = it.toLong(),
    writerName = "writer $it",
    profileImageUrl = "profileImageUrl $it",
    content = "content $it",
    order = createOrder(it),
    writtenAt = it.toLong(),
    title = "title $it",
    rating = it,
    reviewImages = (it..it + 2).map { reviewImage ->
        "reviewImage $reviewImage"
    },
    reply = if (it % 2 == 0) {
        createReply(it)
    } else {
        null
    }
)

private fun createReply(it: Int) = Reply(
    id = it.toLong(),
    writerName = "writerName $it",
    profileImageUrl = if (it % 4 == 0) "profileImageUrl $it" else null,
    content = "content $it",
    writtenAt = it.toLong()
)

