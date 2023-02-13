package com.example.yumarketforowners.reviewmanage.inquirychat.presentation.mapper

import com.example.yumarketforowners.reviewmanage.inquirychat.domain.model.Chat
import com.example.yumarketforowners.reviewmanage.inquirychat.presentation.viewholder.ChatUiState
import com.example.yumarketforowners.core.presentation.viewholder.CellType

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