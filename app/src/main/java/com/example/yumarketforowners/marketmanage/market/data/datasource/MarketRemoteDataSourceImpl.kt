package com.example.yumarketforowners.marketmanage.market.data.datasource

import android.accounts.NetworkErrorException
import com.example.yumarketforowners.core.data.api.MarketApi
import com.example.yumarketforowners.marketmanage.market.data.dto.MarketDto
import com.example.yumarketforowners.marketmanage.market.data.dto.UpdateMarketDto
import com.example.yumarketforowners.di.singleton.Dispatcher
import com.example.yumarketforowners.di.singleton.DispatcherType
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MarketRemoteDataSourceImpl @Inject constructor(
    private val api: MarketApi,
    @Dispatcher(DispatcherType.IO) private val ioDispatcher: CoroutineDispatcher
) : MarketRemoteDataSource {

    override suspend fun getMarketDetailById(marketId: String): MarketDto =
        withContext(ioDispatcher) {
            val response = api.getMarketDetailById(marketId = marketId)

            if (response.isSuccessful) {
                return@withContext response.body()!!.data
            } else {
                throw NetworkErrorException()
            }
        }

    override suspend fun updateMarket(market: UpdateMarketDto) {
        TODO("Not yet implemented")
    }
}