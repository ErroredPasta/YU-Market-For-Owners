package com.example.yumarketforowners.data.remote.dto.market


import com.google.gson.annotations.SerializedName

data class MarketDto(
    @SerializedName("addressInfo")
    val addressInfo: AddressInfo,

    @SerializedName("branchInfo")
    val branchInfo: BranchInfo,

    @SerializedName("businessNumber")
    val businessNumber: String, // 1234-5678-9999

    @SerializedName("categoryInfo")
    val categoryInfo: CategoryInfo,

    @SerializedName("deliveryTipPerDistanceList")
    val deliveryTipPerDistanceList: List<DeliveryTipPerDistance>,

    @SerializedName("latLon")
    val latLon: LatLon,

    @SerializedName("reviewNumber")
    val reviewNumber: Int, // 0

    @SerializedName("salesInfo")
    val salesInfo: SalesInfo,

    @SerializedName("shopDescription")
    val shopDescription: String, // 공부맛집입니다..

    @SerializedName("shopId")
    val shopId: String, // cc898844-8f2f-451e-bccf-2e84cb195c46

    @SerializedName("shopImageInfo")
    val shopImageInfo: ShopImageInfo,

    @SerializedName("shopName")
    val shopName: String, // 롯데리아 영남대DT점

    @SerializedName("totalScore")
    val totalScore: Double, // 0.0
)