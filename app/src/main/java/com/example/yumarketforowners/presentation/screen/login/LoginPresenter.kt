package com.example.yumarketforowners.presentation.screen.login

import com.example.yumarketforowners.domain.usecase.auth.LoginUseCase
import com.example.yumarketforowners.domain.usecase.auth.UserNotFoundException
import com.example.yumarketforowners.presentation.screen.base.BaseCoroutinePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Provider

class LoginPresenter(
    private val view: LoginView,
    private val loginUseCase: LoginUseCase,
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
}