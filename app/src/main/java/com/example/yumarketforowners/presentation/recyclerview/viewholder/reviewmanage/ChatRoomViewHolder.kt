package com.example.yumarketforowners.presentation.recyclerview.viewholder.reviewmanage

import com.example.yumarketforowners.presentation.recyclerview.listener.AdapterListener
import com.example.yumarketforowners.presentation.recyclerview.listener.reviewmanage.ChatRoomViewHolderListener
import com.example.yumarketforowners.presentation.recyclerview.viewholder.BaseViewHolder
import com.example.yumarketforowners.domain.model.chatroom.ChatRoom
import com.example.yumarketforowners.databinding.ViewHolderChatRoomBinding
import com.example.yumarketforowners.presentation.extension.clear
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

    override fun bindListener(listener: AdapterListener) {
        if (listener is ChatRoomViewHolderListener) {
            binding.listener = listener
        }
    }
}