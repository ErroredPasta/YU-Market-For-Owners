package com.example.yumarketforowners.domain.usecase.chatroom

import com.example.yumarketforowners.domain.repository.chatroom.ChatRoomRepository

class RemoveChatRoomUseCase(
    private val repository: ChatRoomRepository
) {
    suspend operator fun invoke(chatRoomId: Long) = repository.deleteChatRoom(chatRoomId)
}
