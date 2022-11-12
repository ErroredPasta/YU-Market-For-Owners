package com.example.yumarketforowners.data.remote.dto.market


import com.google.gson.annotations.SerializedName

data class CategoryInfo(
    @SerializedName("shopCategory")
    val shopCategory: String, // FOOD_BEVERAGE

    @SerializedName("shopDetailCategory")
    val shopDetailCategory: String // FAST_FOOD
)