package com.example.yumarketforowners.reviewmanage.inquirychat.presentation.mapper

import com.example.yumarketforowners.reviewmanage.inquirychat.domain.model.ChatRoom
import com.example.yumarketforowners.reviewmanage.inquirychat.presentation.viewholder.ChatRoomUiState

fun ChatRoom.toChatRoomUiState(
    onClicked: () -> Unit,
    onRemoveClicked: () -> Unit
) = ChatRoomUiState(
    id = id,
    opponentName = opponentName,
    opponentImageUrl = opponentImageUrl,
    lastMessage = lastMessage,
    createdTime = createdTime,
    unreadMessageCount = unreadMessageCount,
    onClicked = onClicked,
    onRemoveClicked = onRemoveClicked
)

fun ChatRoomUiState.toChatRoom() = ChatRoom(
    id = id,
    opponentName = opponentName,
    opponentImageUrl = opponentImageUrl,
    lastMessage = lastMessage,
    createdTime = createdTime,
    unreadMessageCount = unreadMessageCount
)