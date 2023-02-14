package com.example.yumarketforowners.reviewmanage.inquirychat.domain.usecase

import com.example.yumarketforowners.reviewmanage.inquirychat.domain.repository.ChatRoomRepository
import javax.inject.Inject

class RemoveChatRoomUseCase @Inject constructor(
    private val repository: ChatRoomRepository
) {
    suspend operator fun invoke(chatRoomId: Long) = repository.deleteChatRoom(chatRoomId)
}
