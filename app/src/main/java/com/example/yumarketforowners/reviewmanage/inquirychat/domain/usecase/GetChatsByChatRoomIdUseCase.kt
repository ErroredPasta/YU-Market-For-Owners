package com.example.yumarketforowners.reviewmanage.inquirychat.domain.usecase

import com.example.yumarketforowners.reviewmanage.inquirychat.domain.repository.ChatRepository
import javax.inject.Inject

class GetChatsByChatRoomIdUseCase @Inject constructor(
    private val repository: ChatRepository
) {
    operator fun invoke(chatRoomId: Long) = repository.getChatsByChatRoomId(chatRoomId = chatRoomId)
}
