package com.example.yumarketforowners.marketmanage.notice.data.di

import com.example.yumarketforowners.marketmanage.notice.data.datasource.FakeNoticeRemoteDataSource
import com.example.yumarketforowners.marketmanage.notice.data.datasource.NoticeRemoteDataSource
import com.example.yumarketforowners.marketmanage.notice.data.repository.NoticeRepositoryImpl
import com.example.yumarketforowners.marketmanage.notice.domain.repository.NoticeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NoticeDataModule {

    @Binds
    fun bindNoticeRemoteDataSource(dataSource: FakeNoticeRemoteDataSource): NoticeRemoteDataSource

    @Binds
    fun bindNoticeRepository(repository: NoticeRepositoryImpl): NoticeRepository
}