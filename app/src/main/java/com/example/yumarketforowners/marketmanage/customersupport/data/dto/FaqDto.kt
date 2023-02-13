package com.example.yumarketforowners.marketmanage.customersupport.data.dto

import com.example.yumarketforowners.marketmanage.customersupport.domain.model.FaqCategory

data class FaqDto(
    val id: Long,
    val csInfoId: Long,
    val faqCategory: FaqCategory,
    val csTitle: String,
    val csAuthor: String,
    val csContentTitle: String,
    val csContentBody: String
)