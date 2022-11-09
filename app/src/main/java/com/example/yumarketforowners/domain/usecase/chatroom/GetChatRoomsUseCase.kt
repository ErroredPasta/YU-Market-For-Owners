package com.example.yumarketforowners.domain.usecase.chatroom

import com.example.yumarketforowners.domain.repository.chatroom.ChatRoomRepository

class GetChatRoomsUseCase(
    private val repository: ChatRoomRepository
) {
    suspend operator fun invoke(marketId: Long) = repository.getAllChatRoomsByMarketId(marketId)
}