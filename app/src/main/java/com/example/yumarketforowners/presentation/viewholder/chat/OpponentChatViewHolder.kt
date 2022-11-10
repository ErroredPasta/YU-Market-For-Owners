package com.example.yumarketforowners.presentation.viewholder.chat

import com.example.yumarketforowners.databinding.ViewHolderOpponentChatBinding
import com.example.yumarketforowners.presentation.viewholder.BaseViewHolder

class OpponentChatViewHolder(
    binding: ViewHolderOpponentChatBinding
) : BaseViewHolder<ViewHolderOpponentChatBinding, ChatUiState>(binding) {

    override fun bindData(model: ChatUiState) {
        super.bindData(model)
        /* TODO: 2022-11-9 수 04:38, bind data */
        binding.chatUiState = model
    }
}