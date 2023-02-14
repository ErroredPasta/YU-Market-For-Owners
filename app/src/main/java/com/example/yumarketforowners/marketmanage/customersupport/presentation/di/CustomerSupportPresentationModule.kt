package com.example.yumarketforowners.marketmanage.customersupport.presentation.di

import androidx.fragment.app.Fragment
import com.example.yumarketforowners.core.presentation.di.LifeCycleScope
import com.example.yumarketforowners.core.presentation.di.LifeCycleScopeType
import com.example.yumarketforowners.marketmanage.customersupport.domain.repository.CustomerSupportRepository
import com.example.yumarketforowners.marketmanage.customersupport.presentation.screen.faq.FaqListPresenter
import com.example.yumarketforowners.marketmanage.customersupport.presentation.screen.faq.FaqListView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Provider

@Module
@InstallIn(FragmentComponent::class)
object CustomerSupportPresentationModule {

    @Provides
    fun provideCustomerSupportListView(fragment: Fragment) = fragment as FaqListView

    @Provides
    fun provideCustomerSupportListPresenter(
        view: FaqListView,
        repository: CustomerSupportRepository,
        @LifeCycleScope(LifeCycleScopeType.FRAGMENT) scopeProvider: Provider<CoroutineScope>
    ) = FaqListPresenter(
        view = view,
        repository = repository,
        scopeProvider = scopeProvider
    )

}