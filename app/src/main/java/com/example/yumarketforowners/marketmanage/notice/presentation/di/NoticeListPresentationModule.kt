package com.example.yumarketforowners.marketmanage.notice.presentation.di

import androidx.fragment.app.Fragment
import com.example.yumarketforowners.core.presentation.di.LifeCycleScope
import com.example.yumarketforowners.core.presentation.di.LifeCycleScopeType
import com.example.yumarketforowners.marketmanage.notice.domain.usecase.GetAllNoticesUseCase
import com.example.yumarketforowners.marketmanage.notice.presentation.screen.list.NoticeListPresenter
import com.example.yumarketforowners.marketmanage.notice.presentation.screen.list.NoticeListView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Provider

@Module
@InstallIn(FragmentComponent::class)
object NoticeListPresentationModule {

    @Provides
    fun provideNoticeListView(fragment: Fragment) = fragment as NoticeListView

    @Provides
    fun provideNoticeListPresenter(
        view: NoticeListView,
        getAllNoticesUseCase: GetAllNoticesUseCase,
        @LifeCycleScope(LifeCycleScopeType.FRAGMENT) scopeProvider: Provider<CoroutineScope>
    ) = NoticeListPresenter(
        view = view,
        getAllNoticesUseCase = getAllNoticesUseCase,
        scopeProvider = scopeProvider
    )
}