package com.example.yumarketforowners.marketmanage.customersupport.data.di

import com.example.yumarketforowners.marketmanage.customersupport.data.repository.FakeCustomerSupportRepository
import com.example.yumarketforowners.marketmanage.customersupport.domain.repository.CustomerSupportRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CustomerSupportDataModule {

    @Binds
    fun bindCustomerSupportRepository(repository: FakeCustomerSupportRepository): CustomerSupportRepository
}