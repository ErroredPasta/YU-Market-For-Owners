package com.example.yumarketforowners.data.remote.dto.market


import com.google.gson.annotations.SerializedName

data class AddressInfo(
    @SerializedName("detailAddress")
    val detailAddress: String,

    @SerializedName("lotNumberAddress")
    val lotNumberAddress: String,

    @SerializedName("roadNameAddress")
    val roadNameAddress: String
)