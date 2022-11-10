package com.example.yumarketforowners.data.remote.dto.market

import com.example.yumarketforowners.domain.model.market.DetailMarketType
import com.example.yumarketforowners.domain.model.market.MarketType
import java.time.DayOfWeek
import java.time.LocalTime

// CRUD
data class MarketDto(
    val id: String, // not updatable
    val name: String,
    val marketRepresentativeImage: String,
    val marketDetailImages: List<String>,
    val deliveryFees: List<DeliveryFeeDto>,
    val marketType: MarketType,
    val detailMarketType: DetailMarketType,
    val addressDto: AddressDto,
    val openTime: ClosedRange<LocalTime>,
    val closedDays: List<DayOfWeek>,
    val phoneNumber: String
)

data class UpdateMarketDto(
    val id: String,
    val name: String,
    val marketRepresentativeImage: String,
    val marketDetailImage: String?,
    val deliveryFees: List<DeliveryFeeDto>,
    val openTimeRange: ClosedRange<LocalTime>,
    val closedDays: List<DayOfWeek>,
    val phoneNumber: String
)

data class AddressDto(
    val latitude: Double,
    val longitude: Double,
    val addressString: String,
    val detailAddressString: String
)

data class DeliveryFeeDto(
    val id: Long,
    val priceRange: IntRange,
    val fee: Int
)