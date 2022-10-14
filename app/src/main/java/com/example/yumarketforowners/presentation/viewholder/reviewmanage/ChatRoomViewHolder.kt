package com.example.yumarketforowners.presentation.viewholder.reviewmanage

import com.example.yumarketforowners.databinding.ViewHolderChatRoomBinding
import com.example.yumarketforowners.presentation.extension.clear
import com.example.yumarketforowners.presentation.viewholder.BaseViewHolder
import com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom.ChatRoomUiState

class ChatRoomViewHolder(
    binding: ViewHolderChatRoomBinding
) : BaseViewHolder<ViewHolderChatRoomBinding, ChatRoomUiState>(binding) {
    override fun clear() {
        binding.chatRoomOpponentImage.clear()
    }

    override fun bindData(model: ChatRoomUiState) {
        super.bindData(model)
        binding.chatRoomUiState = model
    }
}