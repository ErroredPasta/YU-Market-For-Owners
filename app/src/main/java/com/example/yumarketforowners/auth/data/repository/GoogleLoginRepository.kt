package com.example.yumarketforowners.auth.data.repository

import com.example.yumarketforowners.auth.data.datasource.UserRemoteDataSource
import com.example.yumarketforowners.auth.domain.repository.LoginRepository
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