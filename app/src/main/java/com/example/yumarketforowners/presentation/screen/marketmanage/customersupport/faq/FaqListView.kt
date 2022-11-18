package com.example.yumarketforowners.presentation.screen.marketmanage.customersupport.faq

import com.example.yumarketforowners.domain.model.customersupport.Faq
import com.example.yumarketforowners.presentation.screen.base.BaseView
import com.example.yumarketforowners.presentation.viewholder.customersupport.FaqUiState

interface FaqListView : BaseView {
    fun onRequestFaqListSuccess(faqList: List<FaqUiState>)
    fun navigateToDetailScreen(faq: Faq)
}