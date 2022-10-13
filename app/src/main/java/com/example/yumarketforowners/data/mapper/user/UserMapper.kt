package com.example.yumarketforowners.data.mapper.user

import com.example.yumarketforowners.data.remote.dto.user.UserDto
import com.example.yumarketforowners.domain.model.user.User


fun User.toUserDto(
    telephoneNumber: String,
    businessRegistrationNumber: String
) = UserDto(
    id = id,
    telephoneNumber = telephoneNumber,
    userName = userName,
    profileImage = profileImage,
    businessRegistrationNumber = businessRegistrationNumber
)

fun UserDto.toUser(
    marketName: String,
) = User(
    id = id,
    userName = userName,
    marketName = marketName,
    profileImage = profileImage
)