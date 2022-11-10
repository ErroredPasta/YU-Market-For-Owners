package com.example.yumarketforowners.data.repository.market

import com.example.yumarketforowners.data.mapper.market.toMarket
import com.example.yumarketforowners.data.mapper.market.toUpdateMarketDto
import com.example.yumarketforowners.data.remote.datasource.market.MarketRemoteDataSource
import com.example.yumarketforowners.domain.model.market.Market
import com.example.yumarketforowners.domain.model.market.UpdateMarket
import com.example.yumarketforowners.domain.repository.market.MarketRepository
import javax.inject.Inject

class MarketRepositoryImpl @Inject constructor(
    private val remoteDataSource: MarketRemoteDataSource
) : MarketRepository {

    override suspend fun getMarketDetailById(marketId: String): Market =
        remoteDataSource.getMarketDetailById(marketId = marketId).toMarket()

    override suspend fun updateMarket(market: UpdateMarket) =
        remoteDataSource.updateMarket(market.toUpdateMarketDto())
}