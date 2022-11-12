package com.example.yumarketforowners.data.remote.dto.market

import com.google.gson.annotations.SerializedName

data class MarketResponseDto(
    @SerializedName("success")
    val success: Boolean,

    @SerializedName("data")
    val data: MarketDto
)