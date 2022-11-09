package com.example.yumarketforowners.domain.repository.chatroom

import com.example.yumarketforowners.domain.model.chatroom.Chat
import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    fun getChatsByChatRoomId(chatRoomId: Long): Flow<List<Chat>>
    suspend fun sendChat(chatRoomId: Long, chat: Chat)
}