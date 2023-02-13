package com.example.yumarketforowners.reviewmanage.inquirychat.data.dto

import java.time.LocalDateTime

data class ChatDto(
    val id: Long,
    val senderId: Long,
    val message: String,
    val sentAt: LocalDateTime
)