package com.example.yumarketforowners.domain.repository.user

import com.example.yumarketforowners.domain.model.user.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    val currentUser: Flow<User?>
    suspend fun getUserById(userId: Long)
    suspend fun updateUser(updatedUser: User)
}