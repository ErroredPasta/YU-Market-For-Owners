package com.example.yumarketforowners.data.repository

import com.example.yumarketforowners.domain.model.chatroom.ChatRoom
import com.example.yumarketforowners.domain.repository.ChatRoomRepository
import com.example.yumarketforowners.entity.createChatRoom

class FakeChatRoomRepository : ChatRoomRepository {
    private val chatRooms = (1..10).map {
        createChatRoom(it)
    }.toMutableList()

    override suspend fun getAllChatRoomsByMarketId(marketId: Long): List<ChatRoom> = chatRooms
    override suspend fun deleteChatRoom(chatRoomId: Long) {
        chatRooms.removeIf { it.id == chatRoomId }
    }
}