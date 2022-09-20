package com.example.yumarketforowners.domain.repository

import com.example.yumarketforowners.domain.model.itemmanage.ItemModel

interface ItemManageRepository {
    fun getItemsByMarketId(marketId: Long): List<ItemModel>
}