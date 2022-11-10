package com.example.yumarketforowners.data.remote.datasource.market

import com.example.yumarketforowners.data.remote.dto.market.MarketDto
import com.example.yumarketforowners.data.remote.dto.market.UpdateMarketDto

interface MarketRemoteDataSource {
    suspend fun getMarketDetailById(marketId: String): MarketDto
    suspend fun updateMarket(market: UpdateMarketDto)
}