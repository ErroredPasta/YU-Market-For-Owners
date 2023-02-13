package com.example.yumarketforowners.marketmanage.market.data.repository

import com.example.yumarketforowners.marketmanage.market.data.mapper.toMarket
import com.example.yumarketforowners.marketmanage.market.data.mapper.toUpdateMarketDto
import com.example.yumarketforowners.marketmanage.market.data.datasource.MarketRemoteDataSource
import com.example.yumarketforowners.marketmanage.market.domain.model.Market
import com.example.yumarketforowners.marketmanage.market.domain.model.UpdateMarket
import com.example.yumarketforowners.marketmanage.market.domain.repository.MarketRepository
import javax.inject.Inject

class MarketRepositoryImpl @Inject constructor(
    private val remoteDataSource: MarketRemoteDataSource
) : MarketRepository {

    override suspend fun getMarketDetailById(marketId: String): Market =
        remoteDataSource.getMarketDetailById(marketId = marketId).toMarket()

    override suspend fun updateMarket(market: UpdateMarket) =
        remoteDataSource.updateMarket(market.toUpdateMarketDto())
}