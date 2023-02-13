package com.example.yumarketforowners.reviewmanage.inquirychat.data.dto

data class ChatRoomDto(
    val id: Long, // not updatable
    val opponentName: String,
    val opponentImageUrl: String? = null,
    val lastMessage: String,
    val createdAt: Long,
    val unreadMessageCount: Int
)
