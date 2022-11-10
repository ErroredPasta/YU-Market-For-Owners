package com.example.yumarketforowners.presentation.mapper.chatroom

import com.example.yumarketforowners.domain.model.chatroom.ChatRoom
import com.example.yumarketforowners.presentation.viewholder.reviewmanage.ChatRoomUiState

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