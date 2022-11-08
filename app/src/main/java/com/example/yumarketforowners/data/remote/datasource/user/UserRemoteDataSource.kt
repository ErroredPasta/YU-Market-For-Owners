package com.example.yumarketforowners.data.remote.datasource.user

import com.example.yumarketforowners.data.remote.dto.user.UserDto
import kotlinx.coroutines.flow.Flow

interface UserRemoteDataSource {
    val currentUser: Flow<UserDto?>
    suspend fun getUserById(userId: Long)
    suspend fun updateUser(updatedUser: UserDto)
}