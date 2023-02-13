package com.example.yumarketforowners.auth.data.datasource

import com.example.yumarketforowners.auth.data.dto.UserDto
import kotlinx.coroutines.flow.Flow

interface UserRemoteDataSource {
    val currentUser: Flow<UserDto?>
    suspend fun getUserById(userId: String)
    suspend fun updateUser(updatedUser: UserDto)
}