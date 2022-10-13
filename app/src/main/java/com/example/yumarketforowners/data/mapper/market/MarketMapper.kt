package com.example.yumarketforowners.data.mapper.market

import com.example.yumarketforowners.data.remote.dto.market.MarketDto
import com.example.yumarketforowners.domain.model.market.Market

fun Market.toMarketDto() = MarketDto(
    id = id,
    name = name,
    marketImage = marketImage,
    marketDetailImages = marketDetailImages,
    deliveryFees = deliveryFees,
    marketType = marketType,
    detailMarketType = detailMarketType,
    address = address,
    openTime = openTime,
    closedDays = closedDays,
    phoneNumber = phoneNumber
)

fun MarketDto.toMarket() = Market(
    id = id,
    name = name,
    marketImage = marketImage,
    marketDetailImages = marketDetailImages,
    deliveryFees = deliveryFees,
    marketType = marketType,
    detailMarketType = detailMarketType,
    address = address,
    openTime = openTime,
    closedDays = closedDays,
    phoneNumber = phoneNumber
)