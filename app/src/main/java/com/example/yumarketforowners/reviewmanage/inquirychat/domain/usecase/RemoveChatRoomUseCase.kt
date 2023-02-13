package com.example.yumarketforowners.reviewmanage.inquirychat.domain.usecase

import com.example.yumarketforowners.reviewmanage.inquirychat.domain.repository.ChatRoomRepository

class RemoveChatRoomUseCase(
    private val repository: ChatRoomRepository
) {
    suspend operator fun invoke(chatRoomId: Long) = repository.deleteChatRoom(chatRoomId)
}
