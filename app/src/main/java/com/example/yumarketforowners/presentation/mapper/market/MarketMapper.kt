package com.example.yumarketforowners.presentation.mapper.market

import com.example.yumarketforowners.domain.model.market.Market
import com.example.yumarketforowners.domain.model.market.UpdateMarket

fun Market.toUpdateMarket() = UpdateMarket(
    id = id,
    name = name,
    marketRepresentativeImage = marketRepresentativeImage,
    marketDetailImage = marketDetailImages.firstOrNull(),
    deliveryFees = deliveryFees,
    openTimeRange = openTimeRange,
    closedDays = closedDays,
    phoneNumber = phoneNumber
)