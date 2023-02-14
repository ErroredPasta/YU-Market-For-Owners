package com.example.yumarketforowners.reviewmanage.review.presentation.di

import androidx.fragment.app.Fragment
import com.example.yumarketforowners.core.presentation.di.LifeCycleScope
import com.example.yumarketforowners.core.presentation.di.LifeCycleScopeType
import com.example.yumarketforowners.reviewmanage.review.domain.usecase.GetReviewsUseCase
import com.example.yumarketforowners.reviewmanage.review.presentation.screen.ReviewListView
import com.example.yumarketforowners.reviewmanage.review.presentation.screen.ReviewManagePresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Provider

@Module
@InstallIn(FragmentComponent::class)
object ReviewPresentationModule {

    @Provides
    fun provideReviewListView(fragment: Fragment) = fragment as ReviewListView

    @Provides
    fun provideReviewManagePresenter(
        view: ReviewListView,
        getReviewsUseCase: GetReviewsUseCase,
        @LifeCycleScope(LifeCycleScopeType.FRAGMENT) scopeProvider: Provider<CoroutineScope>
    ) = ReviewManagePresenter(
        view = view,
        getReviewsUseCase = getReviewsUseCase,
        scopeProvider = scopeProvider
    )
}