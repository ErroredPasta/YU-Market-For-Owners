package com.example.yumarketforowners.auth.data.repository

import com.example.yumarketforowners.auth.data.mapper.toUser
import com.example.yumarketforowners.auth.data.mapper.toUserDto
import com.example.yumarketforowners.auth.data.datasource.UserRemoteDataSource
import com.example.yumarketforowners.auth.domain.model.User
import com.example.yumarketforowners.auth.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) : UserRepository {

    override val currentUser: Flow<User?> = userRemoteDataSource.currentUser.map {
        it?.toUser()
    }

    override suspend fun updateUser(updatedUser: User) =
        userRemoteDataSource.updateUser(updatedUser = updatedUser.toUserDto())
}