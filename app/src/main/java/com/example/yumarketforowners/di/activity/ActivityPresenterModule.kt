package com.example.yumarketforowners.di.activity

import com.example.yumarketforowners.di.qualifier.LifeCycleScope
import com.example.yumarketforowners.di.qualifier.LifeCycleScopeType
import com.example.yumarketforowners.domain.usecase.market.GetMarketDetailUseCase
import com.example.yumarketforowners.domain.usecase.market.UpdateMarketUseCase
import com.example.yumarketforowners.presentation.screen.marketmanage.updatemarket.EditMarketPresenter
import com.example.yumarketforowners.presentation.screen.marketmanage.updatemarket.UpdateMarketView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Provider

@Module
@InstallIn(ActivityComponent::class)
object ActivityPresenterModule {

    @Provides
    fun provideEditMarketPresenter(
        view: UpdateMarketView,
        getMarketDetailUseCase: GetMarketDetailUseCase,
        updateMarketUseCase: UpdateMarketUseCase,
        @LifeCycleScope(LifeCycleScopeType.ACTIVITY) scopeProvider: Provider<CoroutineScope>
    ) = EditMarketPresenter(
        view = view,
        getMarketDetailUseCase = getMarketDetailUseCase,
        updateMarketUseCase = updateMarketUseCase,
        scopeProvider = scopeProvider
    )
}