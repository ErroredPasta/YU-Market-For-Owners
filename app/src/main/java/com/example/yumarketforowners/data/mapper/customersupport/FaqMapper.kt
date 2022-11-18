package com.example.yumarketforowners.data.mapper.customersupport

import com.example.yumarketforowners.data.remote.dto.customersupport.FaqDto
import com.example.yumarketforowners.domain.model.customersupport.Faq

fun FaqDto.toCustomerSupport() = Faq(
    id = id,
    csInfoId = csInfoId,
    faqCategory = faqCategory,
    csTitle = csTitle,
    csAuthor = csAuthor,
    csContentTitle = csContentTitle,
    csContentBody = csContentBody
)