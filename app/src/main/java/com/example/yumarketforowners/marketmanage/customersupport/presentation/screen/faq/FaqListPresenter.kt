package com.example.yumarketforowners.marketmanage.customersupport.presentation.screen.faq

import com.example.yumarketforowners.marketmanage.customersupport.domain.model.FaqCategory
import com.example.yumarketforowners.marketmanage.customersupport.domain.repository.CustomerSupportRepository
import com.example.yumarketforowners.marketmanage.customersupport.presentation.mapper.toCustomerSupportUiState
import com.example.yumarketforowners.core.presentation.base.BaseCoroutinePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Provider


class FaqListPresenter(
    private val view: FaqListView,
    private val repository: CustomerSupportRepository,
    scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(view, scopeProvider) {

    fun requestCustomerSupportList(faqCategory: FaqCategory) {
        coroutineScope.launch {
            view.loading(isLoading = true)
            val result = repository.getFaqByCategory(faqCategory = faqCategory).map {
                it.toCustomerSupportUiState(
                    onClick = { view.navigateToDetailScreen(faq = it) }
                )
            }
            view.loading(isLoading = false)

            view.onRequestFaqListSuccess(faqList = result)
        }
    }
}

