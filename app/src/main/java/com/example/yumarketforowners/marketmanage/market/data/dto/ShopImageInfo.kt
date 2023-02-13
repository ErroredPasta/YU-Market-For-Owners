package com.example.yumarketforowners.marketmanage.market.data.dto


import com.google.gson.annotations.SerializedName

data class ShopImageInfo(
    @SerializedName("mainImage")
    val mainImage: String,

    @SerializedName("representativeImageList")
    val representativeImageList: List<String>
)