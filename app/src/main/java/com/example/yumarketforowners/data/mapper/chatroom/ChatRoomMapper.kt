package com.example.yumarketforowners.data.mapper.chatroom

import com.example.yumarketforowners.data.remote.dto.chatroom.ChatRoomDto
import com.example.yumarketforowners.domain.model.chatroom.ChatRoom

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