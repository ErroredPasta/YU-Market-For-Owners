package com.example.yumarketforowners.presentation.viewholder.reviewmanage

import com.example.yumarketforowners.databinding.ViewHolderReviewBinding
import com.example.yumarketforowners.presentation.extension.clear
import com.example.yumarketforowners.presentation.viewholder.BaseViewHolder
import com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.review.ReviewUiState

class ReviewViewHolder(
    binding: ViewHolderReviewBinding
) : BaseViewHolder<ViewHolderReviewBinding, ReviewUiState>(binding) {
    override fun clear() {
        binding.reviewWriterProfileImage.clear()
    }

    override fun bindData(model: ReviewUiState) {
        super.bindData(model)
        binding.reviewUiState = model
    }
}