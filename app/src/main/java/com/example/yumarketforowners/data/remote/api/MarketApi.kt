package com.example.yumarketforowners.data.remote.api

import com.example.yumarketforowners.data.remote.dto.market.MarketResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarketApi {

    @GET("/api/v2/shop/detail")
    suspend fun getMarketDetailById(
        @Query("id") marketId: String
    ): Response<MarketResponseDto>
}