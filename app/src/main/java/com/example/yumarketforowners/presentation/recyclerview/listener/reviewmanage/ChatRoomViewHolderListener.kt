package com.example.yumarketforowners.presentation.recyclerview.listener.reviewmanage

import com.example.yumarketforowners.presentation.recyclerview.listener.AdapterListener
import com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom.ChatRoomUiState

interface ChatRoomViewHolderListener : AdapterListener {
    fun onClicked(chatRoom: ChatRoomUiState)
    fun onRemoveClicked(chatRoom: ChatRoomUiState)
}