package com.example.yumarketforowners.reviewmanage.inquirychat.data.datasource

import com.example.yumarketforowners.reviewmanage.inquirychat.data.dto.ChatRoomDto

interface ChatRoomRemoteDataSource {
    suspend fun getChatRoomsByMarketId(marketId: Long): List<ChatRoomDto>
    suspend fun deleteChatRoom(chatRoomId: Long)
}