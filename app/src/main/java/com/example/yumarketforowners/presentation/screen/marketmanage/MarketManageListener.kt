package com.example.yumarketforowners.presentation.screen.marketmanage

import com.example.yumarketforowners.domain.model.marketmanage.UserModel

interface MarketManageListener {
    fun onEditProfileClicked(user: UserModel)

    // TODO: 2022.06.10 define parameters
    fun onEditMarketClicked()
    fun onManageScheduleClicked()
    fun onManageReviewClicked()
    fun onNoticeClicked()
    fun onServiceCenterClicked()
    fun onSettingClicked()
}