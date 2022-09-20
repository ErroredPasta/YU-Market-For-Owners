package com.example.yumarketforowners.presentation.recyclerview.listener.reviewmanage

import com.example.yumarketforowners.presentation.recyclerview.listener.AdapterListener
import com.example.yumarketforowners.domain.model.reviewmanage.ChatRoom

interface ChatRoomViewHolderListener : AdapterListener {
    fun onClicked(chatRoom: ChatRoom)
    fun onRemoveClicked(chatRoom: ChatRoom)
}