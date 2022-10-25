package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom

import com.example.yumarketforowners.presentation.screen.base.BaseView

interface ChatRoomListView : BaseView {
    fun loading(isLoading: Boolean)
    fun onRequestChatRoomsSuccess(chatRooms: List<ChatRoomUiState>)
    fun navigateToChatRoomScreen(chatRoomId: Long)
}