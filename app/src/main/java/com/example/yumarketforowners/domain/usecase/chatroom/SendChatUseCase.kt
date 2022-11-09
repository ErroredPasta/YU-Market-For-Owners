package com.example.yumarketforowners.domain.usecase.chatroom

import com.example.yumarketforowners.domain.model.chatroom.Chat
import com.example.yumarketforowners.domain.repository.chatroom.ChatRepository

class SendChatUseCase(
    private val repository: ChatRepository
) {
    suspend operator fun invoke(chatRoomId: Long, chat: Chat) = repository.sendChat(
        chatRoomId = chatRoomId,
        chat = chat
    )
}