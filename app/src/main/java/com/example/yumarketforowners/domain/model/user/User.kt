package com.example.yumarketforowners.domain.model.user

data class User(
    val id: Long,
    val userName: String,
    val marketName: String,
    val profileImage: String?
)