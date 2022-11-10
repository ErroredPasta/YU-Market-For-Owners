package com.example.yumarketforowners.presentation.mapper.chatroom

import com.example.yumarketforowners.domain.model.chatroom.Chat
import com.example.yumarketforowners.presentation.viewholder.chat.ChatUiState
import com.example.yumarketforowners.presentation.viewholder.CellType

fun Chat.toChatUiState(
    cellType: CellType
) = ChatUiState(
    id = id,
    cellType = cellType,
    senderId = senderId,
    message = message,
    sentAt = sentAt
)

fun ChatUiState.toChat() = Chat(
    id = id,
    senderId = senderId,
    message = message,
    sentAt = sentAt
)