package com.example.yumarketforowners.presentation.recyclerview.viewholder.reviewmanage

import com.example.yumarketforowners.presentation.recyclerview.listener.AdapterListener
import com.example.yumarketforowners.presentation.recyclerview.listener.reviewmanage.ChatRoomViewHolderListener
import com.example.yumarketforowners.presentation.recyclerview.viewholder.BaseViewHolder
import com.example.yumarketforowners.domain.model.reviewmanage.ChatRoom
import com.example.yumarketforowners.databinding.ViewHolderChatRoomBinding
import com.example.yumarketforowners.presentation.extension.clear

class ChatRoomViewHolder(
    binding: ViewHolderChatRoomBinding
) : BaseViewHolder<ViewHolderChatRoomBinding, ChatRoom>(binding) {
    override fun clear() {
        binding.chatRoomOpponentImage.clear()
    }

    override fun bindData(model: ChatRoom) {
        super.bindData(model)
        binding.chatRoomModel = model
    }

    override fun bindListener(listener: AdapterListener) {
        if (listener is ChatRoomViewHolderListener) {
            binding.listener = listener
        }
    }
}