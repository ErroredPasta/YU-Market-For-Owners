package com.example.yumarketforowners.data.remote.dto.market


import com.google.gson.annotations.SerializedName

data class SalesInfo(
    @SerializedName("closeTime")
    val closeTime: String, // 18:00

    @SerializedName("openTime")
    val openTime: String, // 09:00

    @SerializedName("restDayList")
    val restDayList: List<String>,

    @SerializedName("status")
    val status: String // CLOSE
)