package com.example.yumarketforowners.reviewmanage.inquirychat.domain.usecase

import com.example.yumarketforowners.reviewmanage.inquirychat.domain.model.Chat
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.repository.ChatRepository
import javax.inject.Inject

class SendChatUseCase @Inject constructor(
    private val repository: ChatRepository
) {
    suspend operator fun invoke(chatRoomId: Long, chat: Chat) = repository.sendChat(
        chatRoomId = chatRoomId,
        chat = chat
    )
}