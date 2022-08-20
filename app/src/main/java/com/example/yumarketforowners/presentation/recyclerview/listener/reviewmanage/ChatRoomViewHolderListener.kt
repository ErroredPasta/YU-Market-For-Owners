package com.example.yumarketforowners.presentation.recyclerview.listener.reviewmanage

import com.example.yumarketforowners.presentation.recyclerview.listener.AdapterListener
import com.example.yumarketforowners.domain.model.reviewmanage.ChatRoomModel

interface ChatRoomViewHolderListener : AdapterListener {
    fun onClicked(chatRoom: ChatRoomModel)
    fun onRemoveClicked(chatRoom: ChatRoomModel)
}