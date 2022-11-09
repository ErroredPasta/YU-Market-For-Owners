package com.example.yumarketforowners.domain.repository.chatroom

import com.example.yumarketforowners.domain.model.chatroom.ChatRoom

interface ChatRoomRepository {
    suspend fun getAllChatRoomsByMarketId(marketId: Long): List<ChatRoom>
    suspend fun deleteChatRoom(chatRoomId: Long)
}