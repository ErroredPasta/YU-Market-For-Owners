package com.example.yumarketforowners.reviewmanage.inquirychat.presentation.screen

import com.example.yumarketforowners.core.presentation.base.BaseView
import com.example.yumarketforowners.reviewmanage.inquirychat.presentation.viewholder.ChatRoomUiState

interface ChatRoomListView : BaseView {
    fun onRequestChatRoomsSuccess(chatRooms: List<ChatRoomUiState>)
    fun navigateToChatRoomScreen(chatRoomId: Long)
}