package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom

import com.example.yumarketforowners.presentation.screen.base.BaseView

interface ChatRoomListView : BaseView {
    fun onRequestChatRoomsSuccess(chatRooms: List<ChatRoomUiState>)
    fun navigateToChatRoomScreen(chatRoomId: Long)
}