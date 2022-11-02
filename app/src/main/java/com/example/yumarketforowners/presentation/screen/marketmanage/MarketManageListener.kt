package com.example.yumarketforowners.presentation.screen.marketmanage

import com.example.yumarketforowners.domain.model.user.User

interface MarketManageListener {
    fun onEditProfileClicked(user: User)
    fun onUpdateMarketClicked()
    fun onManageScheduleClicked()
    fun onManageReviewClicked()
    fun onNoticeClicked()
    fun onServiceCenterClicked()
    fun onSettingClicked()
}