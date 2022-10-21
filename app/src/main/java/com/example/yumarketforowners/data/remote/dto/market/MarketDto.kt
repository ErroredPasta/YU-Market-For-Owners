package com.example.yumarketforowners.data.remote.dto.market

import com.example.yumarketforowners.domain.model.market.DetailMarketType
import com.example.yumarketforowners.domain.model.market.MarketType
import java.time.DayOfWeek
import java.time.LocalTime

// CRUD
data class MarketDto(
    val id: Long, // not updatable
    val name: String,
    val marketImage: String,
    val marketDetailImages: List<String>,
    val deliveryFees: List<DeliveryFeeDto>,
    val marketType: MarketType,
    val detailMarketType: DetailMarketType,
    val addressDto: AddressDto,
    val openTime: Pair<LocalTime, LocalTime>,
    val closedDays: List<DayOfWeek>,
    val phoneNumber: String
)

data class UpdateMarketDto(
    val id: Long,
    val name: String,
    val marketType: MarketType,
    val marketRepresentativeImage: String,
    val marketDetailImage: String?,
    val addressDto: AddressDto
)

data class AddressDto(
    val latitude: Double,
    val longitude: Double,
    val addressString: String,
    val detailAddressString: String
)

data class DeliveryFeeDto(
    val priceRange: Pair<Int, Int>,
    val fee: Int
)