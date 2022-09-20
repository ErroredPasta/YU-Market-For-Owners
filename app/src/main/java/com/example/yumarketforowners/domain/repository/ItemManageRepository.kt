package com.example.yumarketforowners.domain.repository

import com.example.yumarketforowners.domain.model.itemmanage.Item

interface ItemManageRepository {
    fun getItemsByMarketId(marketId: Long): List<Item>
}