package com.example.yumarketforowners.data.remote.datasource.market

import android.util.Log
import com.example.yumarketforowners.data.remote.dto.market.AddressDto
import com.example.yumarketforowners.data.remote.dto.market.MarketDto
import com.example.yumarketforowners.data.remote.dto.market.UpdateMarketDto
import com.example.yumarketforowners.domain.model.market.DetailMarketType
import com.example.yumarketforowners.domain.model.market.MarketType
import java.time.LocalTime
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "FakeMarketRemoteDataSource"

@Singleton
class FakeMarketRemoteDataSource @Inject constructor() : MarketRemoteDataSource {

    private val marketList = (0..9).map {
        MarketDto(
            id = it.toString(),
            name = "name $it",
            marketRepresentativeImage = "https://picsum.photos/200",
            marketDetailImages = emptyList(), /* TODO: 2022-10-21 금 01:29, empty list */
            deliveryFees = emptyList(), /* TODO: 2022-10-21 금 01:29, empty list */
            marketType = MarketType.values()[it % MarketType.values().size],
            detailMarketType = DetailMarketType.values()[it % DetailMarketType.values().size],
            /* TODO: 2022-10-21 금 15:31, hard coded address */
            addressDto = AddressDto(
                latitude = 37.56649,
                longitude = 126.985065,
                addressString = "서울특별시 중구 을지로2가 11",
                detailAddressString = ""
            ),
            openTime = LocalTime.of(it % 24, 0)..LocalTime.of(it + 1 % 24, 0),
            closedDays = emptyList(), /* TODO: 2022-10-21 금 01:29, empty list */
            phoneNumber = "010-0101-0101"
        )
    }.toMutableList()

    override suspend fun getMarketDetailById(marketId: String): MarketDto {
        val foundMarket = marketList.find { it.id == marketId }
        Log.d(TAG, "getMarketDetailById: $foundMarket")

        return checkNotNull(foundMarket) {
            "${marketId}를 id로 가진 market이 없습니다."
        }
    }

    override suspend fun updateMarket(market: UpdateMarketDto) {
        val updatedMarket = marketList.find { it.id == market.id }?.copy(
            name = market.name,
            marketRepresentativeImage = market.marketRepresentativeImage,
            marketDetailImages = market.marketDetailImage?.let { listOf(it) } ?: emptyList()
        )

        val index = marketList.indexOfFirst { it.id == market.id }

        updatedMarket?.let {
            marketList[index] = it
            Log.d(TAG, "updateMarket: ${marketList[index]}")
        } ?: Log.d(TAG, "updateMarket: no update")
    }

}