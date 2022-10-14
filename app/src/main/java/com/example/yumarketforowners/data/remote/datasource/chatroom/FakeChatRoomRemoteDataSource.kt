package com.example.yumarketforowners.data.remote.datasource.chatroom

import com.example.yumarketforowners.data.remote.dto.chatroom.ChatRoomDto
import javax.inject.Inject

class FakeChatRoomRemoteDataSource @Inject constructor() : ChatRoomRemoteDataSource {

    private val testList = (0..9).map {
        ChatRoomDto(
            id = it.toLong(),
            opponentName = "opponentName $it",
            opponentImageUrl = "https://picsum.photos/200",
            lastMessage = "lastMessage $it",
            createdAt = it.toLong(),
            unreadMessageCount = it
        )
    }

    override suspend fun getChatRoomsByMarketId(marketId: Long) = testList
}