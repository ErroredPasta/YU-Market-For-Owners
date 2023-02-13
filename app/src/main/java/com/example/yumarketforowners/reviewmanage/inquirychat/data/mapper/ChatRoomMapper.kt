package com.example.yumarketforowners.reviewmanage.inquirychat.data.mapper

import com.example.yumarketforowners.reviewmanage.inquirychat.data.dto.ChatRoomDto
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.model.ChatRoom

fun ChatRoom.toChatRoomDto() = ChatRoomDto(
    id = id,
    opponentName = opponentName,
    opponentImageUrl = opponentImageUrl,
    lastMessage = lastMessage,
    createdAt = createdTime,
    unreadMessageCount = unreadMessageCount
)

fun ChatRoomDto.toChatRoom() = ChatRoom(
    id = id,
    opponentName = opponentName,
    opponentImageUrl = opponentImageUrl,
    lastMessage = lastMessage,
    createdTime = createdAt,
    unreadMessageCount = unreadMessageCount
)