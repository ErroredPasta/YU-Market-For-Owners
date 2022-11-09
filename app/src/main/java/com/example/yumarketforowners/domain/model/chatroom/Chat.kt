package com.example.yumarketforowners.domain.model.chatroom

import java.time.LocalDateTime

data class Chat(
    val id: Long,
    val senderId: Long,
    val message: String,
    val sentAt: LocalDateTime
)