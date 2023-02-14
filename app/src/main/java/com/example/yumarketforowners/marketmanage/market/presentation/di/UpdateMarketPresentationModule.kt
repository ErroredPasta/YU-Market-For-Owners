package com.example.yumarketforowners.marketmanage.market.presentation.di

import android.app.Activity
import com.example.yumarketforowners.core.presentation.di.LifeCycleScope
import com.example.yumarketforowners.core.presentation.di.LifeCycleScopeType
import com.example.yumarketforowners.marketmanage.market.domain.usecase.GetMarketDetailUseCase
import com.example.yumarketforowners.marketmanage.market.domain.usecase.UpdateMarketUseCase
import com.example.yumarketforowners.marketmanage.market.presentation.screen.updatemarket.UpdateMarketPresenter
import com.example.yumarketforowners.marketmanage.market.presentation.screen.updatemarket.UpdateMarketView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Provider

@Module
@InstallIn(ActivityComponent::class)
object UpdateMarketPresentationModule {

    @Provides
    fun provideUpdateMarketView(activity: Activity) = activity as UpdateMarketView

    @Provides
    fun provideUpdateMarketPresenter(
        view: UpdateMarketView,
        getMarketDetailUseCase: GetMarketDetailUseCase,
        updateMarketUseCase: UpdateMarketUseCase,
        @LifeCycleScope(LifeCycleScopeType.ACTIVITY) scopeProvider: Provider<CoroutineScope>
    ) = UpdateMarketPresenter(
        view = view,
        getMarketDetailUseCase = getMarketDetailUseCase,
        updateMarketUseCase = updateMarketUseCase,
        scopeProvider = scopeProvider
    )
}