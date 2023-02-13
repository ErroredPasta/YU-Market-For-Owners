package com.example.yumarketforowners.marketmanage.market.data.dto


import com.google.gson.annotations.SerializedName

data class CategoryInfo(
    @SerializedName("shopCategory")
    val shopCategory: String, // FOOD_BEVERAGE

    @SerializedName("shopDetailCategory")
    val shopDetailCategory: String // FAST_FOOD
)