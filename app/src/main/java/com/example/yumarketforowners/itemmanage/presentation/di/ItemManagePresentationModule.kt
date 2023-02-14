package com.example.yumarketforowners.itemmanage.presentation.di

import androidx.fragment.app.Fragment
import com.example.yumarketforowners.core.presentation.di.LifeCycleScope
import com.example.yumarketforowners.core.presentation.di.LifeCycleScopeType
import com.example.yumarketforowners.itemmanage.domain.usecase.GetItemsUseCase
import com.example.yumarketforowners.itemmanage.presentation.screen.ItemManagePresenter
import com.example.yumarketforowners.itemmanage.presentation.screen.ItemManageView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Provider

@Module
@InstallIn(FragmentComponent::class)
object ItemManagePresentationModule {

    @Provides
    fun provideItemManageView(fragment: Fragment) = fragment as ItemManageView

    @Provides
    fun provideItemManagePresenter(
        view: ItemManageView,
        getItemsUseCase: GetItemsUseCase,
        @LifeCycleScope(LifeCycleScopeType.FRAGMENT) scopeProvider: Provider<CoroutineScope>
    ) = ItemManagePresenter(
        view = view,
        getItemsUseCase = getItemsUseCase,
        scopeProvider = scopeProvider
    )

}