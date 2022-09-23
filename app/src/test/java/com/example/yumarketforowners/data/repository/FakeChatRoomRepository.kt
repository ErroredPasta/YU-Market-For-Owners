package com.example.yumarketforowners.data.repository

import com.example.yumarketforowners.domain.model.reviewmanage.ChatRoom
import com.example.yumarketforowners.domain.repository.ChatRoomRepository

class FakeChatRoomRepository : ChatRoomRepository {
    private val chatRooms = (1..10).map {
        ChatRoom(
            id = it.toLong(),
            opponentName = "opponentName $it",
            opponentImageUrl = "opponentImageUrl $it",
            lastMessage = "lastMessage $it",
            createdTime = it.toLong(),
            unreadMessageCount = it
        )
    }.toMutableList()

    override suspend fun getAllChatRoomsByMarketId(marketId: Long): List<ChatRoom> = chatRooms
}