package com.example.yumarketforowners.auth.data.dto

data class UserDto(
    val id: String, // not updatable
    val telephoneNumber: String,
    val userName: String,
    val profileImage: String? = null,
    val businessRegistrationNumber: String? = null
)
