package com.example.yumarketforowners.reviewmanage.inquirychat.presentation.viewholder

import com.example.yumarketforowners.databinding.ViewHolderMyChatBinding
import com.example.yumarketforowners.core.presentation.viewholder.BaseViewHolder

class MyChatViewHolder(
    binding: ViewHolderMyChatBinding
) : BaseViewHolder<ViewHolderMyChatBinding, ChatUiState>(binding) {

    override fun bindData(model: ChatUiState) {
        super.bindData(model)
        /* TODO: 2022-11-9 수 04:38, bind data */
        binding.chatUiState = model
    }
}