package com.example.yumarketforowners.data.remote.dto.market


import com.google.gson.annotations.SerializedName

data class ShopImageInfo(
    @SerializedName("mainImage")
    val mainImage: String,

    @SerializedName("representativeImageList")
    val representativeImageList: List<String>
)