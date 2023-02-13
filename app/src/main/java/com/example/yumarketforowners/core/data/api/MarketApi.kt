package com.example.yumarketforowners.core.data.api

import com.example.yumarketforowners.marketmanage.market.data.dto.MarketResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarketApi {

    @GET("/api/v2/shop/detail")
    suspend fun getMarketDetailById(
        @Query("id") marketId: String
    ): Response<MarketResponseDto>
}