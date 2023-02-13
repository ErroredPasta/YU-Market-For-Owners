package com.example.yumarketforowners.marketmanage.customersupport.data.mapper

import com.example.yumarketforowners.marketmanage.customersupport.data.dto.FaqDto
import com.example.yumarketforowners.marketmanage.customersupport.domain.model.Faq

fun FaqDto.toCustomerSupport() = Faq(
    id = id,
    csInfoId = csInfoId,
    faqCategory = faqCategory,
    csTitle = csTitle,
    csAuthor = csAuthor,
    csContentTitle = csContentTitle,
    csContentBody = csContentBody
)