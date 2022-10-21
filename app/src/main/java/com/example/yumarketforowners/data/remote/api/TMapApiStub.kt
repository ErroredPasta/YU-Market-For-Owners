package com.example.yumarketforowners.data.remote.api

import com.example.yumarketforowners.data.remote.dto.market.AddressDto
import javax.inject.Inject

class TMapApiStub @Inject constructor() : TMapApi {
    override suspend fun getFullTextGeocoding(
        addressString: String,
        detailAddressString: String
    ): AddressDto = AddressDto(
        latitude = 37.553686,
        longitude = 126.925571,
        addressString = addressString,
        detailAddressString = detailAddressString
    )
}