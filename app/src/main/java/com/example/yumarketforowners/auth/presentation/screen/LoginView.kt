package com.example.yumarketforowners.auth.presentation.screen

import com.example.yumarketforowners.core.presentation.base.BaseView

interface LoginView : BaseView {
    fun navigateToMainScreen()
    fun alertLoginFailure()
}