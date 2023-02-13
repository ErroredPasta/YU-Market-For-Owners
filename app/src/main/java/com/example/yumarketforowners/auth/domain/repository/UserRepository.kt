package com.example.yumarketforowners.auth.domain.repository

import com.example.yumarketforowners.auth.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    val currentUser: Flow<User?>
    suspend fun updateUser(updatedUser: User)
}