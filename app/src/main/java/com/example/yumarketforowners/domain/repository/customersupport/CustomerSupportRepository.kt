package com.example.yumarketforowners.domain.repository.customersupport

import com.example.yumarketforowners.domain.model.customersupport.FaqCategory
import com.example.yumarketforowners.domain.model.customersupport.Faq


interface CustomerSupportRepository {
    fun getFaqByCategory(faqCategory: FaqCategory): List<Faq>
}