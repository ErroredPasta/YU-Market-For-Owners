package com.example.yumarketforowners.marketmanage.market.data.dto


import com.google.gson.annotations.SerializedName

data class BranchInfo(
    @SerializedName("branchName")
    val branchName: String,

    @SerializedName("isBranch")
    val isBranch: Boolean // false
)