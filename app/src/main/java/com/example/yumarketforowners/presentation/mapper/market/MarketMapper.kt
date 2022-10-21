package com.example.yumarketforowners.presentation.mapper.market

import com.example.yumarketforowners.domain.model.market.Market
import com.example.yumarketforowners.domain.model.market.UpdateMarket

fun Market.toUpdateMarket() = UpdateMarket(
    id = id,
    name = name,
    marketType = marketType,
    marketRepresentativeImage = marketImage,
    marketDetailImage = marketDetailImages.firstOrNull(),
    address = address,
    detailAddress = detailAddress
)