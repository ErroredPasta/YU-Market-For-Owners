package com.example.yumarketforowners.domain.model.customersupport

data class Faq(
    val id: Long,
    val csInfoId: Long,
    val faqCategory: FaqCategory,
    val csTitle: String,
    val csAuthor: String,
    val csContentTitle: String,
    val csContentBody: String
)