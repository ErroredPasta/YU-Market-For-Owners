package com.example.yumarketforowners.presentation.viewholder.notice

import com.example.yumarketforowners.databinding.ViewHolderNoticeBinding
import com.example.yumarketforowners.presentation.screen.marketmanage.notice.list.NoticeUiState
import com.example.yumarketforowners.presentation.viewholder.BaseViewHolder

class NoticeViewHolder(
    binding: ViewHolderNoticeBinding
) : BaseViewHolder<ViewHolderNoticeBinding, NoticeUiState>(binding) {

    override fun bindData(model: NoticeUiState) {
        super.bindData(model)
        binding.noticeUiState = model
    }
}