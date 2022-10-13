package com.example.yumarketforowners.domain.repository

import com.example.yumarketforowners.domain.model.chatroom.ChatRoom

interface ChatRoomRepository {
    suspend fun getAllChatRoomsByMarketId(marketId: Long): List<ChatRoom>?
}