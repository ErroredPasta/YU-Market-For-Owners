package com.example.yumarketforowners.core.data.api

import com.example.yumarketforowners.marketmanage.market.data.dto.AddressDto

/* TODO: 2022-10-21 금 15:56, implement api interface using Retrofit2 */
interface TMapApi {
    suspend fun getFullTextGeocoding(addressString: String, detailAddressString: String): AddressDto
}