package com.example.yumarketforowners.auth.presentation.screen

import android.util.Log
import com.example.yumarketforowners.auth.domain.usecase.GoogleLoginUseCase
import com.example.yumarketforowners.auth.domain.usecase.KakaoLoginUseCase
import com.example.yumarketforowners.auth.domain.usecase.LoginUseCase
import com.example.yumarketforowners.auth.domain.usecase.UserNotFoundException
import com.example.yumarketforowners.core.presentation.base.BaseCoroutinePresenter
import com.example.yumarketforowners.core.presentation.di.LifeCycleScope
import com.example.yumarketforowners.core.presentation.di.LifeCycleScopeType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class LoginPresenter @Inject constructor(
    private val view: LoginView,
    private val loginUseCase: LoginUseCase,
    private val kakaoLoginUseCase: KakaoLoginUseCase,
    private val googleLoginUseCase: GoogleLoginUseCase,
    @LifeCycleScope(LifeCycleScopeType.ACTIVITY) scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(scopeProvider) {

    fun login(id: String, password: String) {
        coroutineScope.launch {
            try {
                loginUseCase(id = id, password = password)
            } catch (e: UserNotFoundException) {
                view.alertLoginFailure()
                return@launch
            }

            view.navigateToMainScreen()
        }
    }

    fun onKakaoLoginSuccess(kakaoId: Long) {
        coroutineScope.launch {
            kakaoLoginUseCase(id = kakaoId)
            view.navigateToMainScreen()
        }
    }

    fun onGoogleLoginSuccess(googleId: String) {
        Log.d("TAG", "onGoogleLoginSuccess: $googleId")
        coroutineScope.launch {
            googleLoginUseCase(id = googleId)
            view.navigateToMainScreen()
        }
    }
}