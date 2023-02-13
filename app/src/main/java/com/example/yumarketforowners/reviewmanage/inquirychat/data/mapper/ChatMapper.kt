package com.example.yumarketforowners.reviewmanage.inquirychat.data.mapper

import com.example.yumarketforowners.reviewmanage.inquirychat.data.dto.ChatDto
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.model.Chat

fun Chat.toChatDto() = ChatDto(
    id = id,
    senderId = senderId,
    message = message,
    sentAt = sentAt
)

fun ChatDto.toChat() = Chat(
    id = id,
    senderId = senderId,
    message = message,
    sentAt = sentAt
)