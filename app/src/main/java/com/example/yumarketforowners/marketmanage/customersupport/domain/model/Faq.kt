package com.example.yumarketforowners.marketmanage.customersupport.domain.model

data class Faq(
    val id: Long,
    val csInfoId: Long,
    val faqCategory: FaqCategory,
    val csTitle: String,
    val csAuthor: String,
    val csContentTitle: String,
    val csContentBody: String
)