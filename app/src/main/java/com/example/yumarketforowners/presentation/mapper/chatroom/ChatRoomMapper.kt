package com.example.yumarketforowners.presentation.mapper.chatroom

import com.example.yumarketforowners.domain.model.chatroom.ChatRoom
import com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom.ChatRoomUiState

fun ChatRoom.toChatRoomUiState() = ChatRoomUiState(
    id = id,
    opponentName = opponentName,
    opponentImageUrl = opponentImageUrl,
    lastMessage = lastMessage,
    createdTime = createdTime,
    unreadMessageCount = unreadMessageCount
)

fun ChatRoomUiState.toChatRoom() = ChatRoom(
    id = id,
    opponentName = opponentName,
    opponentImageUrl = opponentImageUrl,
    lastMessage = lastMessage,
    createdTime = createdTime,
    unreadMessageCount = unreadMessageCount
)