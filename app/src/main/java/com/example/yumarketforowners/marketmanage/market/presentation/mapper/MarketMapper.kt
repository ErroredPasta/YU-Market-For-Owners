package com.example.yumarketforowners.marketmanage.market.presentation.mapper

import com.example.yumarketforowners.marketmanage.market.domain.model.Market
import com.example.yumarketforowners.marketmanage.market.domain.model.UpdateMarket

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