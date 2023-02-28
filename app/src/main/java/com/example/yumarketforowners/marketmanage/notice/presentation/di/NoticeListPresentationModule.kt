package com.example.yumarketforowners.marketmanage.notice.presentation.di

import androidx.fragment.app.Fragment
import com.example.yumarketforowners.marketmanage.notice.presentation.screen.list.NoticeListView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object NoticeListPresentationModule {

    @Provides
    fun provideNoticeListView(fragment: Fragment) = fragment as NoticeListView
}