package com.example.yumarketforowners.data.repository.market

import com.example.yumarketforowners.data.mapper.market.toMarket
import com.example.yumarketforowners.data.mapper.market.toUpdateMarketDto
import com.example.yumarketforowners.data.remote.api.TMapApi
import com.example.yumarketforowners.data.remote.datasource.market.MarketRemoteDataSource
import com.example.yumarketforowners.domain.model.market.Market
import com.example.yumarketforowners.domain.model.market.UpdateMarket
import com.example.yumarketforowners.domain.repository.market.MarketRepository
import javax.inject.Inject

class MarketRepositoryImpl @Inject constructor(
    private val remoteDataSource: MarketRemoteDataSource,
    private val tMapApi: TMapApi
) : MarketRepository {

    override suspend fun getMarketDetailById(marketId: Long): Market =
        remoteDataSource.getMarketDetailById(marketId = marketId).toMarket()

    override suspend fun updateMarket(market: UpdateMarket) =
        remoteDataSource.updateMarket(
            market.toUpdateMarketDto(
                addressDto = tMapApi.getFullTextGeocoding(
                    addressString = market.address,
                    detailAddressString = market.detailAddress
                )
            )
        )
}