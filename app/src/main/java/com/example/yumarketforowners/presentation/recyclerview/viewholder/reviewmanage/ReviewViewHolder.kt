package com.example.yumarketforowners.presentation.recyclerview.viewholder.reviewmanage

import com.example.yumarketforowners.presentation.recyclerview.listener.AdapterListener
import com.example.yumarketforowners.presentation.recyclerview.listener.reviewmanage.ReviewViewHolderListener
import com.example.yumarketforowners.presentation.recyclerview.viewholder.BaseViewHolder
import com.example.yumarketforowners.domain.model.reviewmanage.ReviewModel
import com.example.yumarketforowners.databinding.ViewHolderReviewBinding
import com.example.yumarketforowners.extension.clear

class ReviewViewHolder(
    binding: ViewHolderReviewBinding
) : BaseViewHolder<ViewHolderReviewBinding, ReviewModel>(binding) {
    override fun clear() {
        binding.reviewWriterProfileImage.clear()
    }

    override fun bindData(model: ReviewModel) {
        super.bindData(model)
        binding.reviewModel = model
    }

    override fun bindListener(listener: AdapterListener) {
        if (listener is ReviewViewHolderListener) {
            binding.listener = listener
        }
    }
}