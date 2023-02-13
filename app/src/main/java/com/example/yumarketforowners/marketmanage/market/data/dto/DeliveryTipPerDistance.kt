package com.example.yumarketforowners.marketmanage.market.data.dto


import com.google.gson.annotations.SerializedName

data class DeliveryTipPerDistance(
    @SerializedName("distance")
    val distance: Double, // 10.0

    @SerializedName("price")
    val price: Int // 2000
)