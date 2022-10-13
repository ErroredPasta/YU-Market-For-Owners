package com.example.yumarketforowners.domain.model.market

import java.time.DayOfWeek
import java.time.LocalTime

data class Market(
    val id: Long,
    val name: String,
    val marketImage: String?,
    val marketDetailImages: List<String>,
    val deliveryFees: List<DeliveryFee>,
    val marketType: MarketType,
    val detailMarketType: DetailMarketType,
    val address: String,
    val openTime: Pair<LocalTime, LocalTime>,
    val closedDays: List<DayOfWeek>,
    val phoneNumber: String
)

data class DeliveryFee(
    val priceRange: Pair<Int, Int>,
    val fee: Int
)