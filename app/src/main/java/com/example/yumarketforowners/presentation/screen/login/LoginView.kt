package com.example.yumarketforowners.presentation.screen.login

import com.example.yumarketforowners.presentation.screen.base.BaseView

interface LoginView : BaseView {
    fun navigateToMainScreen()
    fun alertLoginFailure()
}