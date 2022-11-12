package com.example.yumarketforowners.data.repository.auth

import com.example.yumarketforowners.data.remote.datasource.user.UserRemoteDataSource
import com.example.yumarketforowners.domain.repository.auth.LoginRepository
import javax.inject.Inject

class GoogleLoginRepository @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) : LoginRepository {

    override suspend fun login(id: String, password: String) {
        userRemoteDataSource.getUserById(userId = id)
    }

    override suspend fun logout() {
        TODO("Not yet implemented")
    }
}