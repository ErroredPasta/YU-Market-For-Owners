package com.example.yumarketforowners.domain.usecase.chatroom

import com.example.yumarketforowners.domain.repository.chatroom.ChatRepository

class GetChatsByChatRoomIdUseCase(
    private val repository: ChatRepository
) {
    operator fun invoke(chatRoomId: Long) = repository.getChatsByChatRoomId(chatRoomId = chatRoomId)
}
