package com.example.yumarketforowners.presentation.screen.marketmanage.customersupport.faq

import com.example.yumarketforowners.domain.model.customersupport.FaqCategory
import com.example.yumarketforowners.domain.repository.customersupport.CustomerSupportRepository
import com.example.yumarketforowners.presentation.mapper.customersupport.toCustomerSupportUiState
import com.example.yumarketforowners.presentation.screen.base.BaseCoroutinePresenter
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

