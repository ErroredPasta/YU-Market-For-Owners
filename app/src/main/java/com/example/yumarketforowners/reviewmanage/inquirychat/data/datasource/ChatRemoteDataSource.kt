package com.example.yumarketforowners.reviewmanage.inquirychat.data.datasource

import com.example.yumarketforowners.reviewmanage.inquirychat.data.dto.ChatDto
import kotlinx.coroutines.flow.Flow

interface ChatRemoteDataSource {
    fun getChatsByChatRoomId(chatRoomId: Long): Flow<List<ChatDto>>
    suspend fun sendChat(chatRoomId: Long, chatDto: ChatDto)
}