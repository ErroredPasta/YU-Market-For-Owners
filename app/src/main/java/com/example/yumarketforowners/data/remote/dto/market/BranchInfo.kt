package com.example.yumarketforowners.data.remote.dto.market


import com.google.gson.annotations.SerializedName

data class BranchInfo(
    @SerializedName("branchName")
    val branchName: String,

    @SerializedName("isBranch")
    val isBranch: Boolean // false
)