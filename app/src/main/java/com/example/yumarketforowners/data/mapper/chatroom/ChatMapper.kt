package com.example.yumarketforowners.data.mapper.chatroom

import com.example.yumarketforowners.data.remote.dto.chatroom.ChatDto
import com.example.yumarketforowners.domain.model.chatroom.Chat

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