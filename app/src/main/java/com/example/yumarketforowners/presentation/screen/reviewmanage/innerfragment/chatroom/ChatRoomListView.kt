package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom

import androidx.annotation.StringRes

interface ChatRoomListView {
    fun loading(isLoading: Boolean)
    fun onRequestDataSuccess(data: List<ChatRoomUiState>)
    fun onRequestDataError(@StringRes errorMessage: Int)
}