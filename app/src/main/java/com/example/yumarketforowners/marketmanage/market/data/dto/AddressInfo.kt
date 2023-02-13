package com.example.yumarketforowners.marketmanage.market.data.dto


import com.google.gson.annotations.SerializedName

data class AddressInfo(
    @SerializedName("detailAddress")
    val detailAddress: String,

    @SerializedName("lotNumberAddress")
    val lotNumberAddress: String,

    @SerializedName("roadNameAddress")
    val roadNameAddress: String
)