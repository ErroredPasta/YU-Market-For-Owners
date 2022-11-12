package com.example.yumarketforowners.data.remote.datasource.market

import android.accounts.NetworkErrorException
import com.example.yumarketforowners.data.remote.api.MarketApi
import com.example.yumarketforowners.data.remote.dto.market.MarketDto
import com.example.yumarketforowners.data.remote.dto.market.UpdateMarketDto
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