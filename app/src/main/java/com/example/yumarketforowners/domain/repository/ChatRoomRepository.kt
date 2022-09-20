package com.example.yumarketforowners.domain.repository

import com.example.yumarketforowners.domain.model.reviewmanage.ChatRoom

interface ChatRoomRepository {
    suspend fun getAllReviewsByMarketId(marketId: Long): List<ChatRoom>
}