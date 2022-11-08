package com.example.yumarketforowners.domain.model.user

data class User(
    val id: Long,
    val telephoneNumber: String,
    val userName: String,
    val profileImage: String?,
    val businessRegistrationNumber: String?
)