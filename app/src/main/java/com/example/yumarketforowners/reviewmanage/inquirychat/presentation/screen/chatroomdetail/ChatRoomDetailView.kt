package com.example.yumarketforowners.reviewmanage.inquirychat.presentation.screen.chatroomdetail

import com.example.yumarketforowners.core.presentation.base.BaseView
import com.example.yumarketforowners.reviewmanage.inquirychat.presentation.viewholder.ChatUiState

interface ChatRoomDetailView : BaseView {
    fun onRequestChatsSuccess(chats: List<ChatUiState>)
    fun afterSendingMessage()
}