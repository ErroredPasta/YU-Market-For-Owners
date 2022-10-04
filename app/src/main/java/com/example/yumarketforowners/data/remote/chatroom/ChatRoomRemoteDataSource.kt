package com.example.yumarketforowners.data.remote.chatroom

import com.example.yumarketforowners.domain.model.reviewmanage.ChatRoom

interface ChatRoomRemoteDataSource {
    suspend fun getChatRoomsByMarketId(marketId: Long): List<ChatRoom>
}