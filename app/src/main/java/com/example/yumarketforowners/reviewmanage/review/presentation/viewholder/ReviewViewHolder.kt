package com.example.yumarketforowners.reviewmanage.review.presentation.viewholder

import com.example.yumarketforowners.databinding.ViewHolderReviewBinding
import com.example.yumarketforowners.orderlist.domain.model.Order
import com.example.yumarketforowners.reviewmanage.review.domain.model.Reply
import com.example.yumarketforowners.core.presentation.base.BaseViewHolderState
import com.example.yumarketforowners.core.presentation.viewholder.BaseViewHolder
import com.example.yumarketforowners.core.presentation.viewholder.CellType

class ReviewViewHolder(
    binding: ViewHolderReviewBinding
) : BaseViewHolder<ViewHolderReviewBinding, ReviewUiState>(binding) {
    override fun clear() {
//        binding.reviewWriterProfileImage.clear()
    }

    override fun bindData(model: ReviewUiState) {
        super.bindData(model)
        binding.reviewUiState = model
    }
}

data class ReviewUiState(
    override val id: Long,
    val writerName: String,
    val profileImageUrl: String?,
    val writtenAt: Long,
    val order: Order,
    val title: String?,
    val content: String,
    val rating: Int,
    val reviewImages: List<String>,
    val reply: Reply? = null,
    val onReplyClicked: () -> Unit
) : BaseViewHolderState(id, CellType.REVIEW_CELL)