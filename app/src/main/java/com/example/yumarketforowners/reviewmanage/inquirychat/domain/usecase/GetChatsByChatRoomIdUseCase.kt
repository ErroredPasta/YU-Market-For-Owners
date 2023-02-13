package com.example.yumarketforowners.reviewmanage.inquirychat.domain.usecase

import com.example.yumarketforowners.reviewmanage.inquirychat.domain.repository.ChatRepository

class GetChatsByChatRoomIdUseCase(
    private val repository: ChatRepository
) {
    operator fun invoke(chatRoomId: Long) = repository.getChatsByChatRoomId(chatRoomId = chatRoomId)
}
