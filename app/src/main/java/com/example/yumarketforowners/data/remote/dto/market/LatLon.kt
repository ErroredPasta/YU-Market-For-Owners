package com.example.yumarketforowners.data.remote.dto.market


import com.google.gson.annotations.SerializedName

data class LatLon(
    @SerializedName("latitude")
    val latitude: Double, // 35.8380022
    @SerializedName("longitude")
    val longitude: Double // 128.7561267
)