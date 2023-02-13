package com.example.yumarketforowners.marketmanage.market.data.mapper

import com.example.yumarketforowners.marketmanage.market.data.dto.DeliveryFeeDto
import com.example.yumarketforowners.marketmanage.market.data.dto.MarketDto
import com.example.yumarketforowners.marketmanage.market.data.dto.UpdateMarketDto
import com.example.yumarketforowners.marketmanage.market.domain.model.*
import java.time.DayOfWeek
import java.time.LocalTime

//fun Market.toMarketDto(
//    addressDto: AddressDto
//) = MarketDto(
//    id = id,
//    name = name,
//    marketRepresentativeImage = marketRepresentativeImage,
//    marketDetailImages = marketDetailImages,
//    deliveryFees = deliveryFees.toDeliveryFeeDtos(),
//    marketType = marketType,
//    detailMarketType = detailMarketType,
//    addressDto = addressDto,
//    openTime = openTimeRange,
//    closedDays = closedDays,
//    phoneNumber = phoneNumber
//)
//
//fun MarketDto.toMarket() = Market(
//    id = id,
//    name = name,
//    marketRepresentativeImage = marketRepresentativeImage,
//    marketDetailImages = marketDetailImages,
//    deliveryFees = deliveryFees.toDeliveryFees(),
//    marketType = marketType,
//    detailMarketType = detailMarketType,
//    address = addressDto.addressString,
//    detailAddress = addressDto.detailAddressString,
//    openTimeRange = openTime,
//    closedDays = closedDays,
//    phoneNumber = phoneNumber
//)

fun MarketDto.toMarket() = Market(
    id = shopId,
    name = shopName,
    marketRepresentativeImage = shopImageInfo.mainImage,
    marketDetailImages = shopImageInfo.representativeImageList,
    deliveryFees = emptyList(), /* TODO: 2022-11-12 토 15:11, pass proper delivery fees */
    marketType = MarketType.valueOf(categoryInfo.shopCategory),
    detailMarketType = DetailMarketType.valueOf(categoryInfo.shopDetailCategory),
    address = addressInfo.roadNameAddress,
    detailAddress = addressInfo.detailAddress,
    openTimeRange = LocalTime.parse(salesInfo.openTime)..LocalTime.parse(salesInfo.closeTime),
    closedDays = restDayListToDayOfWeekList(salesInfo.restDayList),
    phoneNumber = "" /* TODO: 2022-11-12 토 15:11, pass proper phone number */
)

@Suppress("UNCHECKED_CAST")
private fun restDayListToDayOfWeekList(restDayList: List<String>) =
    restDayList.map {
        DayOfWeek.values()
            .find { dayOfWeek -> dayOfWeek.toString().contains(it) }
            ?: throw NoSuchElementException("${it}은 잘못된 요일입니다.")
    }

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