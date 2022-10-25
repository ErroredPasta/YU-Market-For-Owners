package com.example.yumarketforowners.data.remote.datasource.chatroom

import com.example.yumarketforowners.data.remote.dto.chatroom.ChatRoomDto

interface ChatRoomRemoteDataSource {
    suspend fun getChatRoomsByMarketId(marketId: Long): List<ChatRoomDto>
    suspend fun deleteChatRoom(chatRoomId: Long)
}