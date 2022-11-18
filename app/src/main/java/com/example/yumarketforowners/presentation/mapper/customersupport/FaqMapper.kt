package com.example.yumarketforowners.presentation.mapper.customersupport

import com.example.yumarketforowners.domain.model.customersupport.Faq
import com.example.yumarketforowners.presentation.screen.marketmanage.customersupport.faq.FaqData
import com.example.yumarketforowners.presentation.viewholder.customersupport.FaqUiState

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