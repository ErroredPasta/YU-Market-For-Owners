package com.example.yumarketforowners.marketmanage.notice.presentation.viewholder

import com.example.yumarketforowners.databinding.ViewHolderNoticeBinding
import com.example.yumarketforowners.marketmanage.notice.domain.model.NoticePriority
import com.example.yumarketforowners.core.presentation.base.BaseViewHolderState
import com.example.yumarketforowners.core.presentation.viewholder.BaseViewHolder
import com.example.yumarketforowners.core.presentation.viewholder.CellType
import java.time.LocalDate

class NoticeViewHolder(
    binding: ViewHolderNoticeBinding
) : BaseViewHolder<ViewHolderNoticeBinding, NoticeUiState>(binding) {

    override fun bindData(model: NoticeUiState) {
        super.bindData(model)
        binding.noticeUiState = model
    }
}

data class NoticeUiState(
    override val id: Long,
    val title: String,
    val content: String,
    val writtenAt: LocalDate,
    val priority: NoticePriority,
    val onNoticeClicked: () -> Unit
) : BaseViewHolderState(id, CellType.NOTICE_CELL)