package com.example.yumarketforowners.marketmanage.market.domain.repository

import com.example.yumarketforowners.marketmanage.market.domain.model.Market
import com.example.yumarketforowners.marketmanage.market.domain.model.UpdateMarket

interface MarketRepository {
    suspend fun getMarketDetailById(marketId: String): Market
    suspend fun updateMarket(market: UpdateMarket)
}
