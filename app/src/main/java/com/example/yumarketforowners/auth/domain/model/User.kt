package com.example.yumarketforowners.auth.domain.model

data class User(
    val id: String,
    val telephoneNumber: String,
    val userName: String,
    val profileImage: String?,
    val businessRegistrationNumber: String?
)