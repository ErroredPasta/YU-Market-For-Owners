package com.example.yumarketforowners.marketmanage.customersupport.presentation.screen.faq

import com.example.yumarketforowners.marketmanage.customersupport.domain.model.Faq
import com.example.yumarketforowners.core.presentation.base.BaseView
import com.example.yumarketforowners.marketmanage.customersupport.presentation.viewholder.FaqUiState

interface FaqListView : BaseView {
    fun onRequestFaqListSuccess(faqList: List<FaqUiState>)
    fun navigateToDetailScreen(faq: Faq)
}