package com.example.yumarketforowners.auth.presentation.di

import android.app.Activity
import com.example.yumarketforowners.auth.domain.usecase.GoogleLoginUseCase
import com.example.yumarketforowners.auth.domain.usecase.KakaoLoginUseCase
import com.example.yumarketforowners.auth.domain.usecase.LoginUseCase
import com.example.yumarketforowners.auth.presentation.screen.LoginPresenter
import com.example.yumarketforowners.auth.presentation.screen.LoginView
import com.example.yumarketforowners.core.presentation.di.LifeCycleScope
import com.example.yumarketforowners.core.presentation.di.LifeCycleScopeType
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Provider


@Module
@InstallIn(ActivityComponent::class)
object LoginPresentationModule {

    @Provides
    fun provideLoginView(activity: Activity) = activity as LoginView

    @Provides
    fun provideLoginPresenter(
        view: LoginView,
        loginUseCase: LoginUseCase,
        kakaoLoginUseCase: KakaoLoginUseCase,
        googleLoginUseCase: GoogleLoginUseCase,
        @LifeCycleScope(LifeCycleScopeType.ACTIVITY) scopeProvider: Provider<CoroutineScope>
    ) = LoginPresenter(
        view = view,
        loginUseCase = loginUseCase,
        kakaoLoginUseCase = kakaoLoginUseCase,
        googleLoginUseCase = googleLoginUseCase,
        scopeProvider = scopeProvider
    )
}