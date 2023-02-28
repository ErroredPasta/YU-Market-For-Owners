package com.example.yumarketforowners.marketmanage.customersupport.presentation.screen.faq

import com.example.yumarketforowners.marketmanage.customersupport.domain.model.FaqCategory
import com.example.yumarketforowners.marketmanage.customersupport.domain.repository.CustomerSupportRepository
import com.example.yumarketforowners.marketmanage.customersupport.presentation.mapper.toCustomerSupportUiState
import com.example.yumarketforowners.core.presentation.base.BaseCoroutinePresenter
import com.example.yumarketforowners.core.presentation.di.LifeCycleScope
import com.example.yumarketforowners.core.presentation.di.LifeCycleScopeType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider


class FaqListPresenter @Inject constructor(
    private val view: FaqListView,
    private val repository: CustomerSupportRepository,
    @LifeCycleScope(LifeCycleScopeType.FRAGMENT) scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(scopeProvider) {

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

