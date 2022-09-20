package com.example.yumarketforowners.data.repository.reviewmanage

import com.example.yumarketforowners.domain.model.reviewmanage.ChatRoom
import com.example.yumarketforowners.domain.repository.ReviewOrChatRoomRepository
import javax.inject.Inject

class ChatRoomRepositoryImpl @Inject constructor() : ReviewOrChatRoomRepository<ChatRoom> {
    private val testList get() = (0..9).map {
        ChatRoom(
            id = it.toLong(),
            opponentName = "name $it",
            opponentImageUrl = "https://picsum.photos/200",
            lastMessage = "last message $it",
            createdTime = System.currentTimeMillis(),
            unreadMessageCount = it
        )
    }

    override fun getAllByMarketId(marketId: Long): List<ChatRoom> = testList
}