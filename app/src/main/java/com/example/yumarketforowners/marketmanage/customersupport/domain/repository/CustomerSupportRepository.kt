package com.example.yumarketforowners.marketmanage.customersupport.domain.repository

import com.example.yumarketforowners.marketmanage.customersupport.domain.model.FaqCategory
import com.example.yumarketforowners.marketmanage.customersupport.domain.model.Faq


interface CustomerSupportRepository {
    fun getFaqByCategory(faqCategory: FaqCategory): List<Faq>
}