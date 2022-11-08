package com.example.yumarketforowners.data.repository.user

import com.example.yumarketforowners.data.mapper.user.toUser
import com.example.yumarketforowners.data.mapper.user.toUserDto
import com.example.yumarketforowners.data.remote.datasource.user.UserRemoteDataSource
import com.example.yumarketforowners.domain.model.user.User
import com.example.yumarketforowners.domain.repository.user.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: UserRemoteDataSource
) : UserRepository {

    override val currentUser: Flow<User?> = remoteDataSource.currentUser.map {
        it?.toUser()
    }

    override suspend fun getUserById(userId: Long) = remoteDataSource.getUserById(userId = userId)

    override suspend fun updateUser(updatedUser: User) =
        remoteDataSource.updateUser(updatedUser = updatedUser.toUserDto())
}