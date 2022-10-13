package com.example.yumarketforowners.data.remote.dto.user

data class UserDto(
    val id: Long, // not updatable
    val telephoneNumber: String,
    val userName: String,
    val profileImage: String? = null,
    val businessRegistrationNumber: String? = null
)
