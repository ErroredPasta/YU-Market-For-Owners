package com.example.yumarketforowners.presentation.screen.login

import android.util.Log
import com.example.yumarketforowners.domain.usecase.auth.GoogleLoginUseCase
import com.example.yumarketforowners.domain.usecase.auth.KakaoLoginUseCase
import com.example.yumarketforowners.domain.usecase.auth.LoginUseCase
import com.example.yumarketforowners.domain.usecase.auth.UserNotFoundException
import com.example.yumarketforowners.presentation.screen.base.BaseCoroutinePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Provider

class LoginPresenter(
    private val view: LoginView,
    private val loginUseCase: LoginUseCase,
    private val kakaoLoginUseCase: KakaoLoginUseCase,
    private val googleLoginUseCase: GoogleLoginUseCase,
    scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(view, scopeProvider) {

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