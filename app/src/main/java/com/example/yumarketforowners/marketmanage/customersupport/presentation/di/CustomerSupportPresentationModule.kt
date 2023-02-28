package com.example.yumarketforowners.marketmanage.customersupport.presentation.di

import androidx.fragment.app.Fragment
import com.example.yumarketforowners.marketmanage.customersupport.presentation.screen.faq.FaqListView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object CustomerSupportPresentationModule {

    @Provides
    fun provideCustomerSupportListView(fragment: Fragment) = fragment as FaqListView
}