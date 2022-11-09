package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom.chatroomdetail

import com.example.yumarketforowners.presentation.screen.base.BaseView

interface ChatRoomDetailView : BaseView {
    fun onRequestChatsSuccess(chats: List<ChatUiState>)
    fun afterSendingMessage()
}