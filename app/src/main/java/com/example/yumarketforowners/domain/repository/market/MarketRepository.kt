package com.example.yumarketforowners.domain.repository.market

import com.example.yumarketforowners.domain.model.market.Market
import com.example.yumarketforowners.domain.model.market.UpdateMarket

interface MarketRepository {
    suspend fun getMarketDetailById(marketId: Long): Market
    suspend fun updateMarket(market: UpdateMarket)
}
