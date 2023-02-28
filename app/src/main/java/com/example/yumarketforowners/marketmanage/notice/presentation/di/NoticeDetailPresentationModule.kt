package com.example.yumarketforowners.marketmanage.notice.presentation.di

import androidx.fragment.app.Fragment
import com.example.yumarketforowners.marketmanage.notice.presentation.screen.detail.NoticeDetailView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object NoticeDetailPresentationModule {

    @Provides
    fun provideNoticeDetailView(fragment: Fragment) = fragment as NoticeDetailView
}