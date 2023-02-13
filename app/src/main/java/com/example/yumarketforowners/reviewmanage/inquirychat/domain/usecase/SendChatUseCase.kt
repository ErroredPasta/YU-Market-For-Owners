package com.example.yumarketforowners.reviewmanage.inquirychat.domain.usecase

import com.example.yumarketforowners.reviewmanage.inquirychat.domain.model.Chat
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.repository.ChatRepository

class SendChatUseCase(
    private val repository: ChatRepository
) {
    suspend operator fun invoke(chatRoomId: Long, chat: Chat) = repository.sendChat(
        chatRoomId = chatRoomId,
        chat = chat
    )
}