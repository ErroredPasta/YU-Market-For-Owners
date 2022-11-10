package com.example.yumarketforowners.data.mapper.market

import com.example.yumarketforowners.data.remote.dto.market.AddressDto
import com.example.yumarketforowners.data.remote.dto.market.DeliveryFeeDto
import com.example.yumarketforowners.data.remote.dto.market.MarketDto
import com.example.yumarketforowners.data.remote.dto.market.UpdateMarketDto
import com.example.yumarketforowners.domain.model.market.DeliveryFee
import com.example.yumarketforowners.domain.model.market.Market
import com.example.yumarketforowners.domain.model.market.UpdateMarket

fun Market.toMarketDto(
    addressDto: AddressDto
) = MarketDto(
    id = id,
    name = name,
    marketRepresentativeImage = marketRepresentativeImage,
    marketDetailImages = marketDetailImages,
    deliveryFees = deliveryFees.toDeliveryFeeDtos(),
    marketType = marketType,
    detailMarketType = detailMarketType,
    addressDto = addressDto,
    openTime = openTimeRange,
    closedDays = closedDays,
    phoneNumber = phoneNumber
)

fun MarketDto.toMarket() = Market(
    id = id,
    name = name,
    marketRepresentativeImage = marketRepresentativeImage,
    marketDetailImages = marketDetailImages,
    deliveryFees = deliveryFees.toDeliveryFees(),
    marketType = marketType,
    detailMarketType = detailMarketType,
    address = addressDto.addressString,
    detailAddress = addressDto.detailAddressString,
    openTimeRange = openTime,
    closedDays = closedDays,
    phoneNumber = phoneNumber
)

fun UpdateMarket.toUpdateMarketDto() = UpdateMarketDto(
    id = id,
    name = name,
    marketRepresentativeImage = marketRepresentativeImage,
    marketDetailImage = marketDetailImage,
    deliveryFees = deliveryFees.toDeliveryFeeDtos(),
    openTimeRange = openTimeRange,
    closedDays = closedDays,
    phoneNumber = phoneNumber
)

private fun List<DeliveryFee>.toDeliveryFeeDtos() = map {
    DeliveryFeeDto(
        id = it.id,
        priceRange = it.priceRange,
        fee = it.fee
    )
}

private fun List<DeliveryFeeDto>.toDeliveryFees() = map {
    DeliveryFee(
        id = it.id,
        priceRange = it.priceRange,
        fee = it.fee
    )
}