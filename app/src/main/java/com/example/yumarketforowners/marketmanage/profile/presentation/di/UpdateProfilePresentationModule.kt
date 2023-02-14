package com.example.yumarketforowners.marketmanage.profile.presentation.di

import android.app.Activity
import com.example.yumarketforowners.auth.domain.usecase.GetCurrentUserUseCase
import com.example.yumarketforowners.auth.domain.usecase.UpdateUserUseCase
import com.example.yumarketforowners.core.presentation.di.LifeCycleScope
import com.example.yumarketforowners.core.presentation.di.LifeCycleScopeType
import com.example.yumarketforowners.marketmanage.profile.presentation.screen.UpdateProfilePresenter
import com.example.yumarketforowners.marketmanage.profile.presentation.screen.UpdateProfileView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Provider

@Module
@InstallIn(ActivityComponent::class)
object UpdateProfilePresentationModule {

    @Provides
    fun provideUpdateProfileView(activity: Activity) = activity as UpdateProfileView

    @Provides
    fun provideUpdateProfilePresenter(
        view: UpdateProfileView,
        getCurrentUserUseCase: GetCurrentUserUseCase,
        updateUserUseCase: UpdateUserUseCase,
        @LifeCycleScope(LifeCycleScopeType.ACTIVITY) scopeProvider: Provider<CoroutineScope>
    ) = UpdateProfilePresenter(
        view = view,
        getCurrentUserUseCase = getCurrentUserUseCase,
        updateUserUseCase = updateUserUseCase,
        scopeProvider = scopeProvider
    )
}