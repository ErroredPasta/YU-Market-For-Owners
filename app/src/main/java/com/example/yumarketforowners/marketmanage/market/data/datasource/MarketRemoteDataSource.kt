package com.example.yumarketforowners.marketmanage.market.data.datasource

import com.example.yumarketforowners.marketmanage.market.data.dto.MarketDto
import com.example.yumarketforowners.marketmanage.market.data.dto.UpdateMarketDto

interface MarketRemoteDataSource {
    suspend fun getMarketDetailById(marketId: String): MarketDto
    suspend fun updateMarket(market: UpdateMarketDto)
}