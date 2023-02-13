package com.example.yumarketforowners.marketmanage.customersupport.presentation.mapper

import com.example.yumarketforowners.marketmanage.customersupport.domain.model.Faq
import com.example.yumarketforowners.marketmanage.customersupport.presentation.screen.faq.FaqData
import com.example.yumarketforowners.marketmanage.customersupport.presentation.viewholder.FaqUiState

fun Faq.toCustomerSupportUiState(
    onClick: () -> Unit
) = FaqUiState(
    id = id,
    csInfoId = csInfoId,
    faqCategory = faqCategory,
    csTitle = csTitle,
    csAuthor = csAuthor,
    csContentTitle = csContentTitle,
    csContentBody = csContentBody,
    onClick = onClick
)

fun Faq.toFaqData() = FaqData(
    csTitle = csTitle,
    csContentTitle = csContentTitle,
    csContentBody = csContentBody,
    csAuthor = csAuthor
)