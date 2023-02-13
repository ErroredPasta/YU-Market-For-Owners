package com.example.yumarketforowners.marketmanage.profile.presentation.screen

import com.example.yumarketforowners.auth.domain.model.User
import com.example.yumarketforowners.core.presentation.base.BaseView

interface UpdateProfileView : BaseView {
    fun onRequestUserSuccess(user: User)
    fun navigateBack()
}