package com.example.yumarketforowners.reviewmanage.inquirychat.data.repository

import com.example.yumarketforowners.reviewmanage.inquirychat.domain.model.ChatRoom
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.repository.ChatRoomRepository
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