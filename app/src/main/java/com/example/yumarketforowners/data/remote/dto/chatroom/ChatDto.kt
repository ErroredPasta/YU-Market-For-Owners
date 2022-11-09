package com.example.yumarketforowners.data.remote.dto.chatroom

import java.time.LocalDateTime

data class ChatDto(
    val id: Long,
    val senderId: Long,
    val message: String,
    val sentAt: LocalDateTime
)