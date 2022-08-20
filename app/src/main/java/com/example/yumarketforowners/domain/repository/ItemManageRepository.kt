package com.example.yumarketforowners.domain.repository

import com.example.yumarketforowners.presentation.screen.itemmanage.ItemManageContract

interface ItemManageRepository {
    fun getItemsByMarketId(marketId: Long): ItemManageContract.State
}