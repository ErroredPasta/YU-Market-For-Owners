package com.example.yumarketforowners.reviewmanage.inquirychat.domain.repository

import com.example.yumarketforowners.reviewmanage.inquirychat.domain.model.ChatRoom

interface ChatRoomRepository {
    suspend fun getAllChatRoomsByMarketId(marketId: Long): List<ChatRoom>
    suspend fun deleteChatRoom(chatRoomId: Long)
}