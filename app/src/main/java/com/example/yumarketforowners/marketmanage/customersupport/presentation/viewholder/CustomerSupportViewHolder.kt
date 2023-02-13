package com.example.yumarketforowners.marketmanage.customersupport.presentation.viewholder

import com.example.yumarketforowners.databinding.ViewHolderFaqBinding
import com.example.yumarketforowners.marketmanage.customersupport.domain.model.FaqCategory
import com.example.yumarketforowners.core.presentation.base.BaseViewHolderState
import com.example.yumarketforowners.core.presentation.viewholder.BaseViewHolder
import com.example.yumarketforowners.core.presentation.viewholder.CellType


class CustomerSupportViewHolder(
    binding: ViewHolderFaqBinding,
) : BaseViewHolder<ViewHolderFaqBinding, FaqUiState>(binding) {

    override fun bindData(model: FaqUiState) {
        super.bindData(model)
        binding.faqUiState = model
    }
}

data class FaqUiState(
    override val id: Long,
    val csInfoId: Long,
    val faqCategory: FaqCategory,
    val csTitle: String,
    val csAuthor: String,
    val csContentTitle: String,
    val csContentBody: String,
    val onClick: () -> Unit
) : BaseViewHolderState(id, CellType.CUSTOMER_SERVICE_CELL)