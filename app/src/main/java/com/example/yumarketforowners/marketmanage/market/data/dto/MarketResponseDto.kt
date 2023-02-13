package com.example.yumarketforowners.marketmanage.market.data.dto

import com.google.gson.annotations.SerializedName

data class MarketResponseDto(
    @SerializedName("success")
    val success: Boolean,

    @SerializedName("data")
    val data: MarketDto
)