package com.example.yumarketforowners.data.remote.dto.customersupport

import com.example.yumarketforowners.domain.model.customersupport.FaqCategory

data class FaqDto(
    val id: Long,
    val csInfoId: Long,
    val faqCategory: FaqCategory,
    val csTitle: String,
    val csAuthor: String,
    val csContentTitle: String,
    val csContentBody: String
)