package com.example.yumarketforowners.auth.data.mapper

import com.example.yumarketforowners.auth.data.dto.UserDto
import com.example.yumarketforowners.auth.domain.model.User


fun User.toUserDto() = UserDto(
    id = id,
    telephoneNumber = telephoneNumber,
    userName = userName,
    profileImage = profileImage,
    businessRegistrationNumber = businessRegistrationNumber
)

fun UserDto.toUser() = User(
    id = id,
    telephoneNumber = telephoneNumber,
    userName = userName,
    profileImage = profileImage,
    businessRegistrationNumber = businessRegistrationNumber
)