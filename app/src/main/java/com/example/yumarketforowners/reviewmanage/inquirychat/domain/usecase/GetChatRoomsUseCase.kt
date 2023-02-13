package com.example.yumarketforowners.reviewmanage.inquirychat.domain.usecase

import com.example.yumarketforowners.reviewmanage.inquirychat.domain.repository.ChatRoomRepository

class GetChatRoomsUseCase(
    private val repository: ChatRoomRepository
) {
    suspend operator fun invoke(marketId: Long) = repository.getAllChatRoomsByMarketId(marketId)
}