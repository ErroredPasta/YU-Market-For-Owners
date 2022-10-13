package com.example.yumarketforowners.data.remote.dto.market

import com.example.yumarketforowners.domain.model.market.DeliveryFee
import com.example.yumarketforowners.domain.model.market.DetailMarketType
import com.example.yumarketforowners.domain.model.market.MarketType
import java.time.DayOfWeek
import java.time.LocalTime

// CRUD
data class MarketDto(
    val id: Long, // not updatable
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