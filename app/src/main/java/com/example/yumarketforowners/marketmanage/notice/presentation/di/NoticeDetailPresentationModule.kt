package com.example.yumarketforowners.marketmanage.notice.presentation.di

import androidx.fragment.app.Fragment
import com.example.yumarketforowners.core.presentation.di.LifeCycleScope
import com.example.yumarketforowners.core.presentation.di.LifeCycleScopeType
import com.example.yumarketforowners.marketmanage.notice.domain.usecase.GetNoticeByIdUseCase
import com.example.yumarketforowners.marketmanage.notice.presentation.screen.detail.NoticeDetailPresenter
import com.example.yumarketforowners.marketmanage.notice.presentation.screen.detail.NoticeDetailView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Provider

@Module
@InstallIn(FragmentComponent::class)
object NoticeDetailPresentationModule {

    @Provides
    fun provideNoticeDetailView(fragment: Fragment) = fragment as NoticeDetailView

    @Provides
    fun provideNoticeDetailPresenter(
        view: NoticeDetailView,
        getNoticeByIdUseCase: GetNoticeByIdUseCase,
        @LifeCycleScope(LifeCycleScopeType.FRAGMENT) scopeProvider: Provider<CoroutineScope>
    ) = NoticeDetailPresenter(
        view = view,
        getNoticeByIdUseCase = getNoticeByIdUseCase,
        scopeProvider = scopeProvider
    )
}