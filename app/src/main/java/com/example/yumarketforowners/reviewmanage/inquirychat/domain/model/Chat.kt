package com.example.yumarketforowners.reviewmanage.inquirychat.domain.model

import java.time.LocalDateTime

data class Chat(
    val id: Long,
    val senderId: Long,
    val message: String,
    val sentAt: LocalDateTime
)