package com.example.yumarketforowners.data.remote.datasource.chatroom

import com.example.yumarketforowners.data.remote.dto.chatroom.ChatDto
import kotlinx.coroutines.flow.Flow

interface ChatRemoteDataSource {
    fun getChatsByChatRoomId(chatRoomId: Long): Flow<List<ChatDto>>
    suspend fun sendChat(chatRoomId: Long, chatDto: ChatDto)
}