package com.example.yumarketforowners.presentation.screen.marketmanage

import com.example.yumarketforowners.domain.model.marketmanage.User

interface MarketManageListener {
    fun onEditProfileClicked(user: User)

    // TODO: 2022.06.10 define parameters
    fun onEditMarketClicked()
    fun onManageScheduleClicked()
    fun onManageReviewClicked()
    fun onNoticeClicked()
    fun onServiceCenterClicked()
    fun onSettingClicked()
}