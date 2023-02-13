package com.example.yumarketforowners.marketmanage.market.domain.model

import java.time.DayOfWeek
import java.time.LocalTime

data class Market(
    val id: String,
    val name: String,
    val marketRepresentativeImage: String,
    val marketDetailImages: List<String>,
    val deliveryFees: List<DeliveryFee>,
    val marketType: MarketType,
    val detailMarketType: DetailMarketType,
    val address: String,
    val detailAddress: String,
    val openTimeRange: ClosedRange<LocalTime>,
    val closedDays: List<DayOfWeek>,
    val phoneNumber: String
)

data class UpdateMarket(
    val id: String,
    val name: String,
    val marketRepresentativeImage: String,
    val marketDetailImage: String?,
    val deliveryFees: List<DeliveryFee>,
    val openTimeRange: ClosedRange<LocalTime>,
    val closedDays: List<DayOfWeek>,
    val phoneNumber: String
)

data class DeliveryFee(
    val id: Long,
    val priceRange: IntRange,
    val fee: Int
)