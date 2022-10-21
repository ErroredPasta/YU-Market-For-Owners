package com.example.yumarketforowners.data.remote.api

import com.example.yumarketforowners.data.remote.dto.market.AddressDto

/* TODO: 2022-10-21 금 15:56, implement api interface using Retrofit2 */
interface TMapApi {
    suspend fun getFullTextGeocoding(addressString: String, detailAddressString: String): AddressDto
}