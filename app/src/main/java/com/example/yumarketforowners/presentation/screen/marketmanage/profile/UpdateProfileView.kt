package com.example.yumarketforowners.presentation.screen.marketmanage.profile

import com.example.yumarketforowners.domain.model.user.User
import com.example.yumarketforowners.presentation.screen.base.BaseView

interface UpdateProfileView : BaseView {
    fun onRequestUserSuccess(user: User)
    fun navigateBack()
}