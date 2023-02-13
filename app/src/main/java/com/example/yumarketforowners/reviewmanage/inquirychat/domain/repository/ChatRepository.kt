package com.example.yumarketforowners.reviewmanage.inquirychat.domain.repository

import com.example.yumarketforowners.reviewmanage.inquirychat.domain.model.Chat
import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    fun getChatsByChatRoomId(chatRoomId: Long): Flow<List<Chat>>
    suspend fun sendChat(chatRoomId: Long, chat: Chat)
}