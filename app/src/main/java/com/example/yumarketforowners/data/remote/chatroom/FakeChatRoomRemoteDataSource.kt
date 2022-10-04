package com.example.yumarketforowners.data.remote.chatroom

import com.example.yumarketforowners.domain.model.reviewmanage.ChatRoom
import javax.inject.Inject

class FakeChatRoomRemoteDataSource @Inject constructor() : ChatRoomRemoteDataSource {

    private val testList
        get() = (0..9).map {
            ChatRoom(
                id = it.toLong(),
                opponentName = "name $it",
                opponentImageUrl = "https://picsum.photos/200",
                lastMessage = "last message $it",
                createdTime = System.currentTimeMillis(),
                unreadMessageCount = it
            )
        }

    override suspend fun getChatRoomsByMarketId(marketId: Long) = testList
}