package com.example.yumarketforowners.data.mapper.user

import com.example.yumarketforowners.data.remote.dto.user.UserDto
import com.example.yumarketforowners.domain.model.user.User


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