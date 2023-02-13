package com.example.yumarketforowners.reviewmanage.inquirychat.presentation.viewholder

import com.example.yumarketforowners.databinding.ViewHolderChatRoomBinding
import com.example.yumarketforowners.core.presentation.extension.clear
import com.example.yumarketforowners.core.presentation.base.BaseViewHolderState
import com.example.yumarketforowners.core.presentation.viewholder.BaseViewHolder
import com.example.yumarketforowners.core.presentation.viewholder.CellType

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

data class ChatRoomUiState(
    override val id: Long,
    val opponentName: String,
    val opponentImageUrl: String?,
    val lastMessage: String,
    val createdTime: Long,
    val unreadMessageCount: Int,
    val onClicked: () -> Unit,
    val onRemoveClicked: () -> Unit
) : BaseViewHolderState(id, CellType.CHAT_ROOM_CELL)