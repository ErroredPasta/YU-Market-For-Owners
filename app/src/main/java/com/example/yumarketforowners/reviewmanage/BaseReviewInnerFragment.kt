package com.example.yumarketforowners.reviewmanage

import com.example.yumarketforowners.reviewmanage.inquirychat.presentation.screen.ChatRoomInnerFragment
import com.example.yumarketforowners.reviewmanage.review.presentation.screen.ReviewInnerFragment

interface BaseReviewInnerFragment {
    enum class Type(
        val tabString: String
    ) {
        // TODO: 2022.05.30 replace hard coded strings to string resources
        REVIEW("리뷰"),
        CHAT_ROOM("문의 채팅"),
    }

    companion object {
        fun newInstance(type: Type) = when (type) {
            Type.REVIEW -> ReviewInnerFragment()
            Type.CHAT_ROOM -> ChatRoomInnerFragment()
        }
    }
}