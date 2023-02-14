package com.example.yumarketforowners.itemmanage.presentation.di

import android.app.Activity
import com.example.yumarketforowners.core.presentation.di.LifeCycleScope
import com.example.yumarketforowners.core.presentation.di.LifeCycleScopeType
import com.example.yumarketforowners.itemmanage.domain.usecase.AddItemUseCase
import com.example.yumarketforowners.itemmanage.presentation.screen.additem.AddItemPresenter
import com.example.yumarketforowners.itemmanage.presentation.screen.additem.AddItemView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Provider

@Module
@InstallIn(ActivityComponent::class)
object AddItemPresentationModule {

    @Provides
    fun provideAddItemView(activity: Activity) = activity as AddItemView

    @Provides
    fun provideAddItemPresenter(
        view: AddItemView,
        addItemUseCase: AddItemUseCase,
        @LifeCycleScope(LifeCycleScopeType.ACTIVITY) scopeProvider: Provider<CoroutineScope>
    ) = AddItemPresenter(
        view = view,
        addItemUseCase = addItemUseCase,
        scopeProvider = scopeProvider
    )
}